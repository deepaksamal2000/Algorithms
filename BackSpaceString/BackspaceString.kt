package com.deepak.rxapplication.rxjava.leetcode

import android.util.Log
import java.lang.StringBuilder
import java.util.*

/*
* Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.
*
* */

/*
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".*/

//Solution----Aproach 1
//iterate through the string
//iteration1 s= a
//iteration2 s=ab
//iteration3 skip
//iteration4 s= ac

    fun backpaceCompare(s: String, t: String): Boolean {
        val final_S_String = removeBackSpaceCharacter1(s)
       println( "backpaceCompare: "+final_S_String.toString())
        val final_T_String = removeBackSpaceCharacter1(t)
        println( "backpaceCompare: "+final_T_String)
        final_S_String.equals(final_T_String)
        return true
    }

    private fun removeBackSpaceCharacter(str: String): String {
        var charString :CharArray = str.toCharArray()
        var duplicateCharString :CharArray = CharArray(charString.size)
        var str_pointer = -1
        for (i in charString.indices) {
            if (charString.get(i) == '#' && str_pointer != -1) {
                str_pointer -= 1
            } else if (str.get(i) != '#') {

                charString[str_pointer + 1] = charString.get(i)
                str_pointer +=1
            }
        }
        return String(charString)
    }

//Solution----Aproach--2
//iterate through the string
//iteration1 s=push a---->a
//iteration2 s=puah b----->ab
//iteration3 # encountered pop b ---------->a
//iteration4 s= push c------->ac

private fun removeBackSpaceCharacter1(str: String): String {
    var charString :CharArray = str.toCharArray()

   var stack:Stack<Char> =Stack()
   for (c in charString)
   {
       if (c != '#')
       {
           stack.push(c)
       }
       else if (!stack.empty()){
           stack.pop()
       }
   }
    val finalString:StringBuilder= StringBuilder()
    while (!stack.isEmpty()){
        finalString.append(stack.pop())
    }
   return finalString.reverse().toString()
}
    fun main() {
        backpaceCompare("ab#c","ad#c")
    }




