package com.deepak.rxapplication.rxjava.leetcode
/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
*/

//Solution Added the linkedList in a SET and check if data already present in the set

fun detectLoop( h : Node?):Boolean{
    var set:HashSet<Node> = HashSet()
    var head = h
    while (head != null) {
        if (set.contains(head))
            return true

        set.add(head)
        head = head.next
    }
    return false
}



class Node(data: Int) {
    var data: Int = data
    var next: Node? = null

}
var head :Node? =null
fun pushNode(data: Int)
{
    var new_node =Node(data)
    new_node.next = head
    head = new_node
}

fun main() {
    pushNode(20)
    pushNode(4)
    pushNode(15)
    pushNode(10)

   // head?.next?.next?.next?.next = head

        println(detectLoop(head))
}

