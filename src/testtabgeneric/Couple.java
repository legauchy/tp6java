package testtabgeneric;

class Couple implements Comparable<Couple>{

    private int a,b;
    
    Couple(int a, int b){
	this.a=a;
	this.b=b;
    }

    Couple(Couple c) {
	this.a=c.a;
	this.b=c.b;
    }

    public boolean lt(Couple c) {
	return a<c.a || (a==c.a && b<c.b);
    }

    public boolean eq(Couple c) {
	return !(lt(c) || c.lt(this));
    }

    public boolean neq(Couple c) {
	return !eq(c);
    }

    public boolean leq(Couple c) {
	return eq(c) || lt(c);
    }

    public boolean gt(Couple c) {
	return !leq(c);
    }

    public boolean geq(Couple c) {
	return eq(c) || gt(c);
    }
   
    public String toString(){
	return "("+a+","+b+")";
    }

    @Override
    public int compareTo(Couple o) {
        if(this.eq(o)) {
            return 0;
        }else if (this.gt(o)) {
            return 1;
        }else {
            return -1;
        }
    }
}
