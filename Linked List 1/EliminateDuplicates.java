package LinkedList;

public class EliminateDuplicates {
	
	public static int lengthIterative(LinkedListNode<Integer> head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
	
	public static LinkedListNode<Integer> eliminateDuplicates(LinkedListNode<Integer> head){
		 int length=lengthIterative(head);
		 if(length==0){
			return head;
		}
		
		LinkedListNode<Integer> curr=head;
		while(curr.next!=null) {
			
			if(curr.data.equals(curr.next.data)) {
				curr.next=curr.next.next;
			}else {
				curr=curr.next;
			}
			
		}
		return head;
		
	}
	public static void main(String[] args) {
		LinkedListNode<Integer> head=Use.takeInput();
		head=eliminateDuplicates(head);
		Use.print(head);
	}

}
