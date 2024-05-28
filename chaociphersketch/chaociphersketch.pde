void setup() {
  size(800, 400);
  background(255);
  
  drawcircle(240, 200, 150, 120, "NKJWHUGVFBAZOMLYXITSRQDEPC");
  drawcircle(560, 200, 150, 120, "SEFGHLWIKCMOPRTUVJXAYZNXQD");
}

//void draw() {
//  background(255);
//  size(400, 400);
//  String s = "A";
//  fill (200);
//  text(s, 40, 40, 280, 320); // Text wraps within text box
//}

void drawcircle(float x, float y, float r, float inner, String cipher) {
  int numsection = 26;
  float section = TWO_PI / numsection; // divides into equal sections of 26
  float notchRadius = r; 
  float notchSize = 20; // Size of the notch
  
  for (int i = 0; i < numsection; i++){
    float startAngle = i * section;
    float endAngle = (i + 1) * section;
    
    // outter circle
    noFill();
    stroke(0); // Set the stroke to black
    strokeWeight(1); 

    arc(x, y, r * 2, r * 2, startAngle, endAngle, PIE);
    
    //inner circle
    fill(255);
    stroke(1);
    ellipse(x, y, inner * 2, inner * 2);
    
    // add letter to each section
    float middleAngle = (startAngle + endAngle) / 2;
    
    // Calculate the position for the letter
    float letterX = x + (inner + (r - inner) / 2) * cos(middleAngle);
    float letterY = y + (inner + (r - inner) / 2) * sin(middleAngle);
    
    // Draw the letter
    char letter = cipher.charAt(i); //lists cipher disks to get letter
    fill(0); 
    textAlign(CENTER, CENTER);
    text(letter, letterX, letterY); 
    
    // Draw the notch, shaped like semi circle
    float notchX = x + notchRadius * cos(middleAngle); // X position of the notch
    float notchY = y + notchRadius * sin(middleAngle); // Y position of the notch
    
    arc(notchX, notchY, notchSize, notchSize, middleAngle - HALF_PI, middleAngle + HALF_PI, OPEN); // Draw the notch
  }
  
}
