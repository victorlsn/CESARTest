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

        assertEquals(2, head.getNodeSize(0));

        head = new Node("1");
        head.setNext(new Node("2"));
        head.getNext().setNext(new Node("3"));
        head.getNext().getNext().setNext(new Node("4"));

        assertEquals(4, head.getNodeSize(0));

        head = new Node("1");
        head.setNext(new Node("2"));
        head.getNext().setNext(new Node("3"));
        head.getNext().getNext().setNext(new Node("4"));
        head.getNext().getNext().getNext().setNext(new Node("5"));

        assertEquals(5, head.getNodeSize(0));
    }

    @Test
    public void isSearchForIntersectionNodeCorrect() throws Exception {

        // Test for lists with different sizes, size difference = 1;
        Node head1 = new Node("Hi, this is the first email! Please reply");
        head1.setNext(new Node("Hi, this is the first reply!"));
        head1.getNext().setNext(new Node("Hi, this is the second reply!"));
        head1.getNext().getNext().setNext(new Node("Hi, this is the third reply!"));
        head1.getNext().getNext().getNext().setNext(new Node("Hi, this is the fourth reply!"));
        head1.getNext().getNext().getNext().getNext().setNext(new Node("Hi, this is the fifth reply!"));

        Node head2 = new Node("Hi, this is a different first email! Please reply");
        head2.setNext(new Node("Hi, this is a different first reply!"));
        head2.getNext().setNext(new Node("Hi, this is the third reply!"));
        head2.getNext().getNext().setNext(new Node("Hi, this is the fourth reply!"));
        head2.getNext().getNext().getNext().setNext(new Node("Hi, this is the fifth reply!"));

        Node intersectionNode = Questions.searchForIntersectionNode(head1, head2);
        Node sameIntersectionNode = Questions.searchForIntersectionNode(head2, head1);

        assertEquals(intersectionNode.getValue(), sameIntersectionNode.getValue());

        // Test for lists with different sizes, size difference = 4
        head1 = new Node("Hi, this is the first email! Please reply");
        head1.setNext(new Node("Hi, this is the first reply!"));
        head1.getNext().setNext(new Node("Hi, this is the second reply!"));
        head1.getNext().getNext().setNext(new Node("Hi, this is the third reply!"));
        head1.getNext().getNext().getNext().setNext(new Node("Hi, this is the fourth reply!"));
        head1.getNext().getNext().getNext().getNext().setNext(new Node("Hi, this is the fifth reply!"));

        head2 = new Node("Hi, this is a different first email! Please reply");
        head2.setNext(new Node("Hi, this is a different first reply!"));
        head2.getNext().setNext(new Node("Hi, this is a different second reply!"));
        head2.getNext().getNext().setNext(new Node("Hi, this is a different third reply!"));
        head2.getNext().getNext().getNext().setNext(new Node("Hi, this is a different fourth reply!"));
        head2.getNext().getNext().getNext().getNext().setNext(new Node("Hi, this is a different fifth reply!"));
        head2.getNext().getNext().getNext().getNext().getNext().setNext(new Node("Hi, this is a different sixth reply!"));
        head2.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node("Hi, this is a different seventh reply!"));
        head2.getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node("Hi, this is the fourth reply!"));
        head2.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node("Hi, this is the fifth reply!"));


        intersectionNode = Questions.searchForIntersectionNode(head1, head2);
        sameIntersectionNode = Questions.searchForIntersectionNode(head2, head1);

        assertEquals(intersectionNode.getValue(), sameIntersectionNode.getValue());

        // Test for lists with same size
        head1 = new Node("Hi, this is the first email! Please reply");
        head1.setNext(new Node("Hi, this is the first reply!"));
        head1.getNext().setNext(new Node("Hi, this is the second reply!"));
        head1.getNext().getNext().setNext(new Node("Hi, this is the third reply!"));

        head2 = new Node("Hi, this is a different first email! Please reply");
        head2.setNext(new Node("Hi, this is a different first reply!"));
        head2.getNext().setNext(new Node("Hi, this is the second reply!"));
        head2.getNext().getNext().setNext(new Node("Hi, this is the third reply!"));

        intersectionNode = Questions.searchForIntersectionNode(head1, head2);
        sameIntersectionNode = Questions.searchForIntersectionNode(head2, head1);

        assertEquals(intersectionNode.getValue(), sameIntersectionNode.getValue());

        // Test for lists with same size
        head1 = new Node("Hi, this is the first email! Please reply");
        head1.setNext(new Node("Hi, this is the first reply!"));
        head1.getNext().setNext(new Node("Hi, this is the second reply!"));
        head1.getNext().getNext().setNext(new Node("Hi, this is the third reply!"));

        head2 = new Node("Hi, this is a different first email! Please reply");
        head2.setNext(new Node("Hi, this is a different first reply!"));
        head2.getNext().setNext(new Node("Hi, this is a different second reply!"));
        head2.getNext().getNext().setNext(new Node("Hi, this is a different third reply!"));

        intersectionNode = Questions.searchForIntersectionNode(head1, head2);
        sameIntersectionNode = Questions.searchForIntersectionNode(head2, head1);

        assertEquals(null, intersectionNode);
        assertEquals(null, sameIntersectionNode);

    }

}