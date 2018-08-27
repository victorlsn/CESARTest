package br.com.victorlsn.questions5_7;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by victorlsn on 27/08/18.
 */

public class Questions {

    // Question 5 - Complexity O(n)
    public static Node removeDuplicateMessages(Node node) {
        HashSet<String> messagesHashSet = new HashSet<>();

        Node currentNode = node;

        Node previousNode = null;

        String currentMessage;
        while (currentNode != null) {
            currentMessage = currentNode.getValue();

            if (messagesHashSet.contains(currentMessage) && previousNode != null) {
                previousNode.setNext(currentNode.getNext());
            }
            else {
                messagesHashSet.add(currentMessage);
                previousNode = currentNode;
            }
            currentNode = currentNode.getNext();
        }

        return previousNode;
    }
}
