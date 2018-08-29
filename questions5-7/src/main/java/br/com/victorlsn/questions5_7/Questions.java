package br.com.victorlsn.questions5_7;

import android.support.annotation.NonNull;

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

    // Question 7 - Complexity O(n)
    public static Node searchForIntersectionNode(Node head1, Node head2) {
        int sizeDifference = Math.abs(head1.getNodeSize(0) - head2.getNodeSize(0));

        if (head1.getNodeSize(0) > head2.getNodeSize(0)) {
            return getIntersectionNode(head1, head2, sizeDifference);
        }
        else {
            return getIntersectionNode(head2, head1, sizeDifference);
        }
    }

    public static Node getIntersectionNode(@NonNull Node bigNode, @NonNull Node smallNode, int sizeDifference) {
        Node bigNodeCopy = bigNode;
        Node smallNodeCopy = smallNode;

        for (int i = 0; i < sizeDifference; i++) {
            bigNodeCopy = bigNodeCopy.getNext();
        }
        while (bigNodeCopy != null && smallNodeCopy != null) {
            if (bigNodeCopy.getValue().equals(smallNodeCopy.getValue())) {
                return bigNodeCopy;
            }
            bigNodeCopy = bigNodeCopy.getNext();
            smallNodeCopy = smallNodeCopy.getNext();
        }

        return null;
    }
}
