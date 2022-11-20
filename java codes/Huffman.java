class HuffmanNode{
    char c;
    int data;
    HuffmanNode left;
    HuffmanNode right;
    public HuffmanNode() {
		// TODO Auto-generated constructor stub
	}
    HuffmanNode(char c,int data){
        this.c=c;
        this.data=data;
    }
}
class MyComparator implements Comparator<HuffmanNode>{
    public int compare(HuffmanNode x, HuffmanNode y){
        return x.data-y.data;
    }
}
public class HuffmanPract {

   
    private static void printcode(HuffmanNode root, String s) {
        if(root.left==null && root.right==null && Character.isLetter(root.c)){
            System.out.println(root.c+" : "+ s);
            return;
        }
        printcode(root.left, s+'0');
        printcode(root.right, s+'1');
    }

    public static void main(String[] args) {
        int n=6;
        char c[]={'a','b','c','d','e','f'};
        int freq[]={5,9,12,13,16,65};

        PriorityQueue<HuffmanNode> q=new PriorityQueue<>(n,new MyComparator());
        for (int i = 0; i < n; i++) {
            HuffmanNode hn=new HuffmanNode(c[i], freq[i]);
            q.add(hn);
        }
        HuffmanNode root=null;
        while(q.size()>1){
            HuffmanNode x=q.peek();
            q.poll();

            HuffmanNode y=q.peek();
            q.poll();

            HuffmanNode f=new HuffmanNode();
            f.data=x.data+y.data;
            f.c='-';
            f.left=x;
            f.right=y;
            root=f;

            q.add(f);
        }
        printcode(root,"");

    }
}
