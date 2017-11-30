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

void nine () {
    digitalWrite(8, HIGH); //0
    digitalWrite(9, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(12, HIGH);
    digitalWrite(13, HIGH);
    digitalWrite(11, HIGH);
}

void eight () {
    digitalWrite(9, HIGH); //1
    digitalWrite(10, HIGH);
    n = n+1;
}

void seven () {
    digitalWrite(8, HIGH); //2
    digitalWrite(9, HIGH);
    digitalWrite(12, HIGH);
    n = n+1;
}

void six () {
    digitalWrite(8, HIGH); //3
    digitalWrite(9, HIGH);
    digitalWrite(A0, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    n = n+1;
}

void five () {
    digitalWrite(13, HIGH); //4
    digitalWrite(9, HIGH);
    digitalWrite(A0, HIGH);
    digitalWrite(10, HIGH); 
    n = n+1;
}

void four() {
    digitalWrite(13, HIGH); //5
    digitalWrite(8, HIGH);
    digitalWrite(A0, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    n = n+1;
}

void three () {
    digitalWrite(13, HIGH); //6
    digitalWrite(8, HIGH);
    digitalWrite(A0, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    digitalWrite(12, HIGH);
    n = n+1;
}

void two () {
    digitalWrite(8, HIGH); //7
    digitalWrite(10, HIGH);
    digitalWrite(9, HIGH);
    n = n+1;
}

void one () {
    digitalWrite(13, HIGH); //8
    digitalWrite(8, HIGH);
    digitalWrite(A0, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    digitalWrite(12, HIGH);
    digitalWrite(9, HIGH);
    n = n+1;
}

void zero () {
    digitalWrite(13, HIGH); //9
    digitalWrite(8, HIGH);
    digitalWrite(A0, HIGH);
    digitalWrite(12, HIGH);
    digitalWrite(9, HIGH);
    n = n+1;
}

void loop () {
 switch (n){
            case 0:
                zero();
                delay(1500);
                turnOff();
                break;
            case 1:
                one();
                delay(1500);
                turnOff();
                break;
            case 2:
                two();
                delay(1500);
                turnOff();
                break;
              case 3:
                three();
                delay(1500);
                turnOff();
                break;
            case 4:
                four();
                delay(1500);
                turnOff();
                break;
            case 5:
                five();
                delay(1500);
                turnOff();
                break;
            case 6:
                two();
                delay(1500);
                turnOff();
                break;
            case 7:
                seven();
                delay(1500);
                turnOff();
                break;
            case 8:
                eight();
                delay(1500);
                turnOff();
                break;
            case 9:
                nine();
                delay(1500);
                turnOff();
                break;
    } 
}
