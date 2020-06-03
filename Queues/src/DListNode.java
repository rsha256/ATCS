public class DListNode {
	private Object value;
	private DListNode next;
	private DListNode previous;

	public DListNode(Object initValue, DListNode initNext, DListNode initPrev) {
		value = initValue;
		next = initNext;
		previous = initPrev;
	}

	public Object getValue() {
		return value;
	}
	
	public DListNode getNext()
	{
	   return next;
	}
	
	public DListNode getPrevious()
	{
		return previous; 
	}
	
	public void setValue(Object value)
	{
		this.value = value;
	}

	public void setNext(DListNode next)
	{
		this.next = next;
	}
	
	public DListNode getLast()
	{
		if(next == null)
		{
			return null;
		}
		DListNode temp = next;
		while(temp.getNext() != null)
		{
			if(next.getNext() == null)
			{
				temp = next;
				return next;
			}
			next = next.getNext();
		}
		return temp;
	}

	
}
	