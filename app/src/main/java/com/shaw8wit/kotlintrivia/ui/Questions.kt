package com.shaw8wit.kotlintrivia.ui

data class Question(
    val text: String,
    val answers: List<String>)

// Put correct answer in index 0 of answers list
val questions: MutableList<Question> = mutableListOf(
    Question(text = "Kotlin is developed by?",
        answers = listOf("JetBrains", "Google", "Microsoft", "Oracle")),

    Question(text = "Which of the following is used to handle null exceptions in Kotlin?",
        answers = listOf("Elvis Operator", "Sealed Class", "Lambda function", "NullPointerException")),

    Question(text = "Which file extension is used to save Kotlin files?",
        answers = listOf(".kt or .kts", ".java", ".android", ".kot")),

    Question(text = "All classes in Kotlin are by default?",
        answers = listOf("final", "public", "sealed", "abstract")),

    Question(text = "Which is the correct way to create an array list in Kotlin?",
        answers = listOf("val list = arrayListOf(1, 2, 3)", "val list = hashSetOf(1, 2, 3)", "val list = hashMapOf(1, 2, 3)", "enum ListOf numbers {1, 2, 3}")),

    Question(text = "What is an immutable variable?",
        answers = listOf("A variable that cannot change", "A variable that can be changed", "A variable used for string interpolation", "Just a fancy name of variables in Kotlin")),

    Question(text = "Which of the following targets is not currently supported by Kotlin?",
        answers = listOf(".NET CLR", "Javascript", "LLVM", "All of them")),

    Question(text = "How to make a multi lined comment in Kotlin?",
        answers = listOf("/* comment */", "// comment", "# comment", "<!-- comment -->")),

    Question(text = "Which of the following constructors are available in Kotlin?",
        answers = listOf("Both Primary and Secondary", "Secondary Constructors", "Primary Constructors", "No constructors are required in Kotlin")),

    Question(text = "What are Kotlin coroutines?",
        answers = listOf("They provide asynchronous code without thread blocking", "These are functions which accept other functions as arguments or return them", "It's Kotlin's term for class methods", "That's how the automatically generated methods hashCode() and equals() in data classes are called")),

    Question(text = "What is 'to' in the example below?\nval test = 33 to 42",
        answers = listOf("An infix extension function creating a Pair(33, 42)", "A Kotlin keyword to create a Pair(33, 42)", "A Kotlin keyword to create a Range from 33 to 42", "A syntax error")),

    Question(text = "What is the correct way to declare a variable of integer type in Kotlin?",
        answers = listOf("var i : Int = 42", "int i = 42", "let i = 42", "val i = Int: 42")),

    Question(text = "What is the correct syntax to convert the String \"42\" to a Long in Kotlin?",
        answers = listOf("val l: Long = \"42\".toLong()", "val l: Long = Long.parseLong(\"42\")", "val l: Long = (Long)\"42\"", "val l: Long = <Long>\"42\"")),

    Question(text = "Does Kotlin have primitive data types, such as int, long, float?",
        answers = listOf("No, not at language level. But the Kotlin compiler makes use of JVM primitives for best performance.", "No, Kotlin does not have nor use primitive data types", "Yes, but Kotlin internally converts them to their non-primitive counterparts", "Yes, Kotlin is similar to Java in this respect")),

    Question(text = "What is the output of the following code?\nval listA = mutableListOf(1, 2, 3)\nval listB = listA.add(4)\nprint(listB)",
        answers = listOf("true", "[1,2,3,4]", "Nothing. There's a compiler error", "Unit")),

    Question(text = "What is the difference between a and b?\nvar a: String? = \"Kotlin Quiz\"\nvar b: String = \"Kotlin Quiz\"",
        answers = listOf("b can never become null", "a is final and cannot be changed", "a is volatile as in Java", "b is final and cannot be changed")),

    Question(text = "What about Java interoperability?",
        answers = listOf("Kotlin can easily call Java code and vice versa", "Kotlin can easily call Java code while Java cannot access code written in Kotlin", "While Kotlin runs on JVM, it cannot interoperate with Java", "Kotlin provides a compatibility layer for Java interoperability which comes with some cost at runtime")),

    Question(text = "Which is a valid function declaration in Kotlin?",
        answers = listOf("fun sum(a:Int, b:Int):Int", "int sum(int a, int b)", "function sum(a:Int, b:Int):Int", "int sum(a:Int, b:Int)")),

    Question(text = "What does the !! operator do?",
        answers = listOf("It converts any value to a non-null type and throws an exception if the value is in fact null", "It's the modulo operator in Kotlin similar to Java's %", "It compares two values for identity rather than equality", "It returns the left-hand operand if the operand is not null, otherwise it returns the right hand operand")),

    Question(text = "What is the output of the following code?\nval list: List<Int> = listOf(1, 2, 3)\nlist.add(4)\nprint(list)",
        answers = listOf("It does not compile as List has no add method", "[1, 2, 3, 4]", "It does not compile, as listOf is not known", "[5, 6, 7]")),

    Question(text = "What is the key difference between Iterable<T> and Sequence<T> in Kotlin?",
        answers = listOf("Sequences are processed lazily, while Iterables eagerly", "Iterable<T> works only on immutable collections, Sequence<T> is also applicable to mutable ones", "Sequences are processed sequentially, Iterables in parallel(multithreaded)", "There's no difference")),

    Question(text = "What is the type of arr in the following code?\nval arr = arrayOf(1, 2, 3)",
        answers = listOf("Array<Int>", "Int[]", "int[]", "IntArray")),

    Question(text = "What does the following code print?\nval a: String? = null\nval b: String = \"Hello Kotlin\"\nprintln(a==b)",
        answers = listOf("false", "Nothing, but throws NullPointerException", "Does not compile", "true")),

    Question(text = "Which is true for the following simple class declaration?\nclass Person(val name: String)",
        answers = listOf("It is public", "It is package-private", "It has a private property \"name\"", "It can be extended by other classes"))
)