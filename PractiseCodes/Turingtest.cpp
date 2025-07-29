//0^n1^n
#include <iostream>
#include <cstring>
using namespace std;

int main() {
    int current = 0;
    char inputstr[10], c;
    
    cout << "Enter string ";
    cin >> inputstr;

    int i = 0;
    
    while (true) {
        c = inputstr[i]; 
        
        switch (current) {
            case 0: 
                if (c == '0') {
                    inputstr[i] = 'X'; // Write 'X'
                    i++; // Move right
                    current = 1; // Move to state 1
                }
                else if (c == 'Y') {
                    i++; // Move right
                    current = 3; // Move to state 3
                }
                else if (c == '\0') {
                    current = 4; // End state (accept)
                }
                else {
                    current = -1; // Reject state
                }
                break;
            
            case 1:
                if (c == '0') {
                    i++; // Move right
                    current = 1;
                }
                else if (c == 'Y') {
                    i++; // Move right
                    current = 1;
                }
                else if (c == '1') {
                    inputstr[i] = 'Y'; // Write 'Y'
                    i--; // Move left
                    current = 2; // Move to state 2
                }
                else {
                    current = -1; // Reject state
                }
                break;
            
            case 2:
                if (c == '0') {
                    i--; // Move left
                    current = 2;
                }
                else if (c == 'Y') {
                    i--; // Move left
                    current = 2;
                }
                else if (c == 'X') {
                    i++; // Move right
                    current = 0; // Return to state 0
                }
                else {
                    current = -1; // Reject state
                }
                break;
            
            case 3:
                if (c == 'Y') {
                    i++; // Move right
                    current = 3;
                }
                else if (c == '\0') {
                    current = 4; 
                }
                else {
                    current = -1; 
                }
                break;
            
        }
        
        
        if (current == 4) {
            cout << "Accepted string" << endl;
            break;
        }
        
        if (current == -1) {
            cout << "Rejected string" << endl;
            break;
        }
    }
    
    return 0;
}
