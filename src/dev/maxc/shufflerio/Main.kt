package dev.maxc.shufflerio

import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

/**
 * @author Max Carter
 * @since  10/10/2019
 */
fun main() {
    val sepSet = "\n[!-!-!]"
    val sepQuestion = "[-!-]"
    var text = ""
    while (true) {
        val question = getText("Enter question:")
        val answer = getText("Enter answer to [$question]:")
        if (answer == "x" || question == "x") {
            println(text)
        } else {
            val clipboard = Toolkit.getDefaultToolkit().systemClipboard
            clipboard.setContents(StringSelection(text), null)
            text+= sepSet + question + sepQuestion + answer
        }
    }
}

fun getText(question: String) : String {
    println(question)
    return readLine()!!
}