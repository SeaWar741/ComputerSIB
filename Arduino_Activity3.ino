int n=0;

void setup() {
  // put your setup code here, to run once:
  pinMode(0,OUTPUT);
  pinMode(8,OUTPUT);
  pinMode(9,OUTPUT);
  pinMode(10,OUTPUT);
  pinMode(11,OUTPUT);
  pinMode(12,OUTPUT);
  pinMode(13,OUTPUT);
  pinMode(A0,OUTPUT);
  pinMode(A1,OUTPUT);
  pinMode(A2,OUTPUT);
  pinMode(A3,OUTPUT);
}


void turnOff () {
  digitalWrite(13, LOW); //8
  digitalWrite(8, LOW);
  digitalWrite(A0, LOW);
  digitalWrite(10, LOW);
  digitalWrite(11, LOW);
  digitalWrite(12, LOW);
  digitalWrite(9, LOW);
}


void dispNum (int n){
  if (n==9) {
    digitalWrite(8, HIGH); //0
    digitalWrite(9, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(12, HIGH);
    digitalWrite(13, HIGH);
    digitalWrite(11, HIGH);
  }

  else if (n==8) {
    digitalWrite(9, HIGH); //1
    digitalWrite(10, HIGH);
    n = n++;  
  }

  else if (n==7) { 
    digitalWrite(8, HIGH); //2
    digitalWrite(9, HIGH);
    digitalWrite(12, HIGH);
    n = n++;
    
  }

  else if (n==6) {
    digitalWrite(8, HIGH); //3
    digitalWrite(9, HIGH);
    digitalWrite(A0, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    n = n++;    
  }

  else if (n==5) {
    digitalWrite(13, HIGH); //4
    digitalWrite(9, HIGH);
    digitalWrite(A0, HIGH);
    digitalWrite(10, HIGH); 
    n = n++;
  }

  else if (n==4) {
    digitalWrite(13, HIGH); //5
    digitalWrite(8, HIGH);
    digitalWrite(A0, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    n = n++;
  }


  else if (n==3) {
    digitalWrite(13, HIGH); //6
    digitalWrite(8, HIGH);
    digitalWrite(A0, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    digitalWrite(12, HIGH);
    n = n++;
  }
  else if (n==2) {
    digitalWrite(8, HIGH); //7
    digitalWrite(10, HIGH);
    digitalWrite(9, HIGH);
    n = n++;
  }

  else if (n==1) {
    digitalWrite(13, HIGH); //8
    digitalWrite(8, HIGH);
    digitalWrite(A0, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    digitalWrite(12, HIGH);
    digitalWrite(9, HIGH);
    n = n++;
  }

  else if (n==0) {
    digitalWrite(13, HIGH); //9
    digitalWrite(8, HIGH);
    digitalWrite(A0, HIGH);
    digitalWrite(12, HIGH);
    digitalWrite(9, HIGH);
    n = n++;
  }
}
void loop () {
 switch (n){
            case 0:
                dispNum(n);
                delay(500);
                break;
            case 1:
                dispNum(n);
                delay(500);
                break;
            case 2:
                dispNum(n);
                delay(500);
                break;
            case 3: 
                dispNum(n);
                delay(500);
                break;
            case 4:
                dispNum(n);
                delay(500);
                break;
            case 5:
                dispNum(n);
                delay(500);
                break;
            case 6:
                dispNum(n);
                delay(500);
                break;
            case 7:
                dispNum(n);
                delay(500);
                break;
            case 8:
                dispNum(n);
                delay(500);
                turnOff ();
                break;
    } 
}