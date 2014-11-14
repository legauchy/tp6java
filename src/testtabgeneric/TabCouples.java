package testtabgeneric;

class TabCouples {

    private static final int DEFAULT=10;

    private Couple[] tab;

    private final int n;

    private int nbElt;

    TabCouples(final int n) {
	this.n=n;
	tab=new Couple[n];
	nbElt=0;
    }

    TabCouples() {
	this(DEFAULT);
    }  

    public int size(){
	return nbElt;
    }
    
    public boolean empty(){
	return size()==0;
    }

    public Couple value(int i) {
	return tab[i];
    }

    private Couple[] copy(Couple[] t) {
	for(int i=0;i<size();i++) t[i]=value(i);
	return t;
    }

    private void grow() {
	tab=copy(new Couple[tab.length+n]);
    }

    public void add(Couple c) {
	if(size()==tab.length) grow();
	tab[nbElt++]=c;
    }
 
    public Couple remove() {
	return value(--nbElt);
    }

    public void modify(int i,Couple c) {
	tab[i]=c;
    }

    public void insert(int i,Couple c) {
	if(size()==tab.length) grow();
	for(int j=size();j>i;j--) tab[j]=value(j-1);
	tab[i]=c;
	nbElt++;
    }

    public Couple remove(int i) {
	Couple c=value(i);
	for(int j=i;j<size()-1;j++) tab[j]=value(j+1);
	nbElt--;
	return c;
    }

    private String toString(int i) {
	if (i>=size()) return "";
	if (i==size()-1) return value(i).toString();
	return value(i)+","+toString(i+1);
    }

    public String toString() {
	String s=null;
	s = "["+toString(0)+"]";
	return s;
    }


}
