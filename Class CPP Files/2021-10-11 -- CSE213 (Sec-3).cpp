/*
#include<iostream>
#include<cstdlib>
using namespace std;

class ComplexNo{
	int real, img;
	public:
	void setComplexNo(){		//version-1
		cout<<"Enter real value: "; cin>>real;
		cout<<"Enter imaginary value: "; cin>>img;
	}
	void setComplexNo(int p, int q){	//version-2
		real=p;
		img=q;
	}
	void showComplex(){
		//cout<<real;
		//if(img>=0) cout<<"+";
		//cout<<img<<"i"<<endl;

		cout<<real<<(img>=0?"+":"")<<img<<"i"<<endl;
	}
};


int main(){
	ComplexNo c1, c2, c3;

	c1.setComplexNo();
	....
	c2.setComplexNo();
	.....
	c1.showComplex();
	c2.showComplex();
	c3.setComplexNo(rand()%10, rand()%20);
	c3.showComplex();
	return 0;
}
*/
//---------------------------------------------
/*
#include<iostream>
using namespace std;

class Person{
    int tipsEarned = 0;
    public:
	Person buyFoodFromMarket(){
		cout<<"Food is bought."<<endl;
		//we need to return the client
		tipsEarned += 50;
		return *this;
	}
	Person organizeLivingRoom(){
		cout<<"Living room is organized."<<endl;
		tipsEarned += 50;
		return *this;
	}
	//void serveFood(){
    Person serveFood(){
		cout<<"Food is served."<<endl;
		tipsEarned += 50;
		return *this;
	}
	void showEarnedTipsAmpont(){
        cout<<"Total tips earned is : "<<tipsEarned<<endl;
	}
};

bool doSome(){
    cout<<"Doing something..."<<endl;
    return true;
}
int main(){
    //if(doSome()){cout<<"Successfully."<<endl;}
    doSome();
	Person babu, rafiq;
	//babu.buyFoodFromMarket();
	//babu.organizeLivingRoom();
	//babu.serveFood();

	Person cloneOfClone = babu.buyFoodFromMarket().organizeLivingRoom().serveFood();
	babu.showEarnedTipsAmpont();
	cloneOfClone.showEarnedTipsAmpont();
	return 0;
}
*/
//---------------------------------
/*
#include<iostream>
using namespace std;

int main(){
    int x=35, y, val;
    y = x<<2;
    cin>>val;
    cout<<"x="<<x<<", y="<<y<<endl;
	return 0;
}
*/
//------------------------------------------
/*
#include<iostream>
using namespace std;

class ComplexNo{
	int real, img;
	public:
    int getReal(){ return real; }
    int getImg(){ return img; }

    void setReal(int val){ real = val; }
    void setImg(int img){
        (*this).img = img;
        //this->img = img;
    }

	void setComplexNo(){
		cout<<"Enter real value: "; cin>>real;
		cout<<"Enter imaginary value: "; cin>>img;
	}
	void showComplex(){
		cout<<real<<(img>=0?"+":"")<<img<<"i"<<endl;
	}
	ComplexNo add(ComplexNo c){
        ComplexNo temp;
        temp.real = real + c.real;
        temp.img = img + c.img;
        return temp;
	}
	ComplexNo operator+(ComplexNo c){
        ComplexNo temp;
        temp.real = real + c.real;
        temp.img = img + c.img;
        return temp;
	}
	ComplexNo operator+(int val){
        ComplexNo temp;
        temp.real = real + val;
        temp.img = img;
        return temp;
	}
	//friend void operator>>(istream&, ComplexNo&);
	friend istream& operator>>(istream&, ComplexNo&);
};

ComplexNo operator+(int val, ComplexNo c){
    ComplexNo temp;
    temp.setReal( c.getReal() + val );
    temp.setImg( c.getImg() + val );
    return temp;
}

//void operator>>(istream& in, ComplexNo& c){
istream& operator>>(istream& in, ComplexNo& c){
    //code to link in with KB
    cout<<"Enter real value: "; in>>c.real;
	cout<<"Enter imaginary value: "; in>>c.img;
	return in;
}

ostream& operator<<(ostream& out, ComplexNo c){
    out<<c.getReal()<<(c.getImg()>=0?"+":"")
        <<c.getImg()<<"i";
	return out;
}

int main(){
	ComplexNo c1, c2, c3, c4, c5;
	//istream myIn;
	//need to link myIn with KB first, int x; myIn>>x;
	cout<<"Enter ComplexNo c1:"<<endl; cin>>c1;
	cout<<"Enter ComplexNo c2:"<<endl; cin>>c2;
	//cin>>c3>>c4;
	cout<<"Complex no c1 = "<<c1<<endl;
	cout<<"Complex no c2 = "<<c2<<endl;
	//c3 = c1.add(c2);
	//cout<<"After c3 = c1.add(c2), Complex no c3 = ";c3.showComplex();
	c3 = c1 + c2;
	cout<<"After c3=c1+c2, Complex no c3 = "<<c3<<endl;

	c4 = c3 + 10; //assume real will be increased by 10
	cout<<"After c4=c3+10, Complex no c4 = "<<c4<<endl;

	c5 = 2 + c4; //assume real & img will be increased by 2
	cout<<"After c5=2+c4, Complex no c5 = "<<c5<<endl;

	return 0;
}
*/
//-----------------------------------------------
#include<iostream>
using namespace std;

class ComplexNo{
	int real, img;
	public:
    int getReal(){ return real; }
    int getImg(){ return img; }

    void setReal(int val){ real = val; }
    void setImg(int img){
        (*this).img = img;
        //this->img = img;
    }

	void setComplexNo(){
		cout<<"Enter real value: "; cin>>real;
		cout<<"Enter imaginary value: "; cin>>img;
	}
	void showComplex(){
		cout<<real<<(img>=0?"+":"")<<img<<"i"<<endl;
	}
	ComplexNo add(ComplexNo c){
        ComplexNo temp;
        temp.real = real + c.real;
        temp.img = img + c.img;
        return temp;
	}
	ComplexNo operator+(ComplexNo c){
        ComplexNo temp;
        temp.real = real + c.real;
        temp.img = img + c.img;
        return temp;
	}
	ComplexNo operator+(int val){
        ComplexNo temp;
        temp.real = real + val;
        temp.img = img;
        return temp;
	}

	//void operator++(){
	//ComplexNo operator++(){
	ComplexNo& operator++(){    //PRE
        real++; img++;
        return *this;
	}

	//ComplexNo operator++(float x){
	ComplexNo operator++(int x){    //POST
	    ComplexNo temp;
	    temp.real=real; temp.img=img;
	    //temp = *this;
        real++; img++;
        return temp;
	}
	//call: ++c1;
	//call: c2 = ++c1;
	//friend void operator>>(istream&, ComplexNo&);
	friend istream& operator>>(istream&, ComplexNo&);


	//call: c3 = c2++;

};

ComplexNo operator+(int val, ComplexNo c){
    ComplexNo temp;
    temp.setReal( c.getReal() + val );
    temp.setImg( c.getImg() + val );
    return temp;
}

//void operator>>(istream& in, ComplexNo& c){
istream& operator>>(istream& in, ComplexNo& c){
    //code to link in with KB
    cout<<"Enter real value: "; in>>c.real;
	cout<<"Enter imaginary value: "; in>>c.img;
	return in;
}

ostream& operator<<(ostream& out, ComplexNo c){
    out<<c.getReal()<<(c.getImg()>=0?"+":"")
        <<c.getImg()<<"i";
	return out;
}

int main(){
	ComplexNo c1, c2, c3, c4, c5;
    cout<<"Enter complex no c1:"<<endl; cin>>c1;
    cout<<"c1="<<c1<<endl;  //1 2
    c2 = ++c1;
    cout<<"after c2=++c1, c1="<<c1<<", c2="<<c2<<endl;
    //after c2=++c1, c1=2+3i, c2=2+3i

    c3 = c2++;
    cout<<"after c3=c2++, c2="<<c2<<", c3="<<c3<<endl;
    //after c3=c2++, c2=3+4i, c3=2+3i


	return 0;
}
