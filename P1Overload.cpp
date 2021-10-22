#include <bits/stdc++.h>
#include <string>
using namespace std;

class Address
{
public:
    string houseNo, roadNo, street, thana, district;
    int zipCode;

public:
    void setAdress(istream &in)
    {

        cout << "houseNo, roadNo, street, thana, district,Zip Code" << endl;
        in >> houseNo >> roadNo >> street >> thana >> district >> zipCode;
    }
    void getAdd(ostream &out)
    {
        out << " houseNo:" << houseNo << " roadNo: " << roadNo << " street: " << street << endl;
        out << " thana: " << thana << " district: " << district << " Zip Code: " << zipCode << endl;
    }

    friend istream &
    operator>>(istream &, Address &);

    friend istream &operator>>(istream &, Address &);

    friend ostream &operator<<(ostream &, Address &);
};

istream &operator>>(istream &in, Address &c)
{
    c.setAdress(in);
    return in;
}

ostream &operator<<(ostream &out, Address &c)
{
    c.getAdd(out);
    return out;
}

class Employee
{
    int ID;
    Address empAdd;
    string name, department;

public:
    void setEmp(istream &in)
    {

        cout << "Enter ID: ";
        in >> ID;
        cout << "Enter Name: ";
        in >> name;
        cout << "Enter dept.:";
        in >> department;
        in >> empAdd;
    }

    void getEmp(ostream &out)
    {
        out << "ID: " << ID << endl;
        out << "Name: " << name << endl;
        out << "dept.:" << department << endl;
        out << "Adress:" << empAdd << endl;
    }

    int getZip(){
        return empAdd.zipCode;
    }
    friend istream &operator>>(istream &, Employee &);
    friend ostream &operator<<(ostream &, Employee &);
    friend bool &operator==(Employee &, int &);
};

bool operator==(Employee &c, int zip)
{
    if (c.getZip() == zip)
    {
        return true;
    }
    else
        return false;
}

istream &operator>>(istream &in, Employee &c)
{

    c.setEmp(in);
    return in;
}

ostream &operator<<(ostream &out, Employee &c)
{
    c.getEmp(out);
    return out;
}

int main()
{
    Employee e1, e2;

    //e1.setEmp();
    cin >> e1;
    cout << e1 << endl;

    if (e1 == 1229)
    {
        cout << "Lives basundara r/a" << endl;
    }
    else
        cout << " does not lives basundara r/a" << endl;

    return 0;
}