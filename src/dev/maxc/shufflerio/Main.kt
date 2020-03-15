package dev.maxc.shufflerio

import java.awt.datatransfer.StringSelection
import java.awt.Toolkit

const val EXIT = "x"
const val INPUT_CATEGORY = "c"
const val INPUT_PACKAGE = "p"
const val VOID_QUESTION = "v"
const val HELP = "h"

/**
 * @author Max Carter
 * @since  15/03/2020
 */
fun main() {
    var text = "["
    var currentPackage = getText("Enter package:")
    var currentCategory = getText("Enter category:")

    while (true) {
        div()
        val question = getText("Enter question:")
        val answer = getText("Enter answer to [$question]:")

        if (answer == EXIT || question == EXIT) {
            text = text.removeSuffix(",")
            text += "\n]"
            val clipboard = Toolkit.getDefaultToolkit().systemClipboard
            clipboard.setContents(StringSelection(text), null)
            div()
            println(text)

        } else if (answer == INPUT_CATEGORY || question == INPUT_CATEGORY) {
            currentCategory = getText("Enter category:")

        } else if (answer == INPUT_PACKAGE || question == INPUT_PACKAGE) {
            currentPackage = getText("Enter package:")

        } else if (answer == VOID_QUESTION || question == VOID_QUESTION) {
            println("Question Voided...")
            continue

        } else if (answer == HELP || question == HELP) {
            println("Exit: $EXIT")
            println("Input Category: $INPUT_CATEGORY")
            println("Input Package: $INPUT_PACKAGE")
            println("Void Question: $VOID_QUESTION")

        } else {
            if (text.endsWith("]")) {
                text = text.replace("\n]", ",")
            }
            text += "\n\t{\n"
            text += eachLine("title", question)
            text += eachLine("answer", answer)
            text += eachLine("category", currentCategory)
            text += eachLine("packageBundle", currentPackage)
            text += "\t},"
        }
    }
}

//⇔ ⇒ ∄ ∃ ∀ ≠ ≥ ≤ π ∑ e ⋂ ⋃ ⊆ ⊂ ⊄ ∈ ∉ ⊕ ∧ ∨

fun eachLine(obj: String, value: Any) =
    "\t\t\"$obj\": ${if (value is Int) value else "\"$value\""}" + (if (obj != "packageBundle") "," else "") + "\n"

fun div() = println(" = - = - = - = - = - = - = - = - = - = ")

/**
 * @author Max Carter
 * @since  10/10/2019
 */
@Deprecated("Message output not supported by ShufflerX")
fun mainOld() {
    val sepSet = "\n[!-!-!]"
    val sepQuestion = "[-!-]"
    var text = ""
    while (true) {
        val question = getText("Enter question:")
        val answer = getText("Enter answer to [$question]:")
        if (answer == "x" || question == "x") {
            val clipboard = Toolkit.getDefaultToolkit().systemClipboard
            clipboard.setContents(StringSelection(text), null)
            println(text)
        } else {
            text += sepSet + question + sepQuestion + answer
        }
    }
}

fun getText(question: String): String {
    var text: String? = ""
    while (text == "") {
        print("$question ")
        text = readLine()!!.trim()
    }
    return text!!
}