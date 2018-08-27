package br.com.victorlsn.questions5_7;

/**
 * Created by victorlsn on 27/08/18.
 */

public class Node {
    private String value;
    private Node next;
    public Node(String value){
        this.value = value;
        next = null;
    }
    public Node(String value, Node next){
        this.value = value;
        next = next;
    }
    public String getValue(){
        return this.value;
    }
    public Node getNext(){
        return this.next;
    }
    public void setValue(String value){
        this.value = value;
    }
    public void setNext(Node next){
        this.next = next;
    }

    @Override
    public String toString() {
        return next != null ? value + "\n" + next.toString() : value;
    }
}