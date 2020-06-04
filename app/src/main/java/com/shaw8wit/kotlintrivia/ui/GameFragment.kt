package com.shaw8wit.kotlintrivia.ui


import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar

import com.shaw8wit.kotlintrivia.R
import com.shaw8wit.kotlintrivia.databinding.FragmentGameBinding
import kotlin.math.min

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = min((questions.size + 1) / 2, 5)
    private val minimumCorrect = (numQuestions / 2) + 1
    private var correctObtained = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false
        )

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.game = this

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }
                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    correctObtained++
                    showResponse(true)
                } else { // Advance to the next question
                    showResponse(false)
                }
                // Advance to the next question if required
                questionIndex++
                if (questionIndex < numQuestions) {
                    currentQuestion = questions[questionIndex]
                    setQuestion()
                    binding.invalidateAll()
                } else {
                    if (correctObtained >= minimumCorrect) {
                        // We've won!  Navigate to the gameWonFragment.
                        view.findNavController().navigate(
                            GameFragmentDirections.actionGameFragmentToGameWonFragment(
                                correctObtained,
                                numQuestions
                            )
                        )
                    } else {
                        // Game over! If minimum correct answer is not obtained, it sends us to the gameOverFragment.
                        view.findNavController()
                            .navigate(
                                GameFragmentDirections.actionGameFragmentToGameOverFragment(
                                    correctObtained,
                                    numQuestions
                                )
                            )
                    }
                }
            }
        }
        return binding.root
    }

    private fun showResponse(isCorrect: Boolean) {
        val parentView: View = activity!!.findViewById(android.R.id.content)
        val message = if (isCorrect) "Correct!!" else "Wrong!!"
        val snackBar = Snackbar.make(parentView, message, Snackbar.LENGTH_SHORT)
            .setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)

        val snackView = snackBar.view
        snackView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        val params = snackView.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP
        snackView.layoutParams = params
        val color = if (isCorrect) {
            ContextCompat.getColor(activity!!.applicationContext, R.color.correct)
        } else {
            ContextCompat.getColor(activity!!.applicationContext, R.color.incorrect)
        }
        snackView.setBackgroundColor(color)

        snackBar.show()
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
// Calling invalidateAll on the FragmentGameBinding updates the data in UI.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title = getString(
            R.string.title_kotlin_trivia_question,
            questionIndex + 1, numQuestions
        )
    }
}
