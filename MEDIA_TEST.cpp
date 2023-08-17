/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>

using namespace std;

int main()
{
    int nota_1;
    int nota_2;
    int nota_3;
    cout<<"entre com a primeira nota: ";
        
    cin >> nota_1;
    
    while(nota_1 > 10 || nota_1 < 0){
        cout << "nota invalida!!" << endl;
        cout << "insira outra nota: ";
        cin >> nota_1;
    }

    cout<<"entre com a segunda nota: ";
        
    cin >> nota_2;
    
    while(nota_2 > 10 || nota_2 < 0){
        cout << "nota invalida!!" << endl;
        cout << "insira outra nota: ";
        cin >> nota_2;
    }
    
    cout<<"entre com a terceira nota: " ;
        
    cin >> nota_3;
    
    while(nota_3 > 10 || nota_3 < 0){
        cout << "nota invalida!!" << endl << endl;
        cout << "insira outra nota: ";
        cin >> nota_3;
    }
    
    float media;
    
    media = (nota_1 + nota_2 + nota_3)/3;
    

    
    cout <<"Sua media: " << media;
    
    
    return 0;
}
