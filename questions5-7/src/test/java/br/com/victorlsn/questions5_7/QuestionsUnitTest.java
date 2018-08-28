package br.com.victorlsn.questions5_7;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class QuestionsUnitTest {

    @Test
    public void isRemoveDuplicatesFromLinkedListNodeCorrect() throws Exception {
        Node head = new Node("Hi, this is the first email! Please reply");
        head.setNext(new Node("Hi, this is the first reply!"));
        head.getNext().setNext(new Node("Hi, this is the second reply!"));
        head.getNext().getNext().setNext(new Node("Hi, this is the first reply!"));
        head.getNext().getNext().getNext().setNext(new Node("Hi, this is the third reply!"));
        head.getNext().getNext().getNext().getNext().setNext(new Node("Hi, this is the second reply!"));
        head.getNext().getNext().getNext().getNext().getNext().setNext(new Node("Hi, this is the first reply!"));

        String messages = head.toString();

        Questions.removeDuplicateMessages(head);

        String cleanMessages = head.toString();

        assertNotEquals(messages, cleanMessages);
    }

    @Test
    public void isGetNodeSizeCorrect() throws Exception {
        Node head = new Node("1");
        head.setNext(new Node("2"));

        assertEquals(2, Questions.getNodeSize(head, 0));

        head = new Node("1");
        head.setNext(new Node("2"));
        head.getNext().setNext(new Node("3"));
        head.getNext().getNext().setNext(new Node("4"));

        assertEquals(4, Questions.getNodeSize(head, 0));

        head = new Node("1");
        head.setNext(new Node("2"));
        head.getNext().setNext(new Node("3"));
        head.getNext().getNext().setNext(new Node("4"));
        head.getNext().getNext().getNext().setNext(new Node("5"));

        assertEquals(5, Questions.getNodeSize(head, 0));
    }

}