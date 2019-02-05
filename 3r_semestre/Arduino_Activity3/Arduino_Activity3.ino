int n=0;

void setup() {
  // put your setup code here, to run once:
  pinMode(8,OUTPUT);
  pinMode(9,OUTPUT);
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
  digitalWrite(8, HIGH);
  digitalWrite(9, HIGH)
}
