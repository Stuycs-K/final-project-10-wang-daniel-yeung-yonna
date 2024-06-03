float leftAngleOffset = 0;
float rightAngleOffset = 0;

void setup() {
  size(800, 500);
  background(255);
}

void draw() {
  background(255); //need it to reset the background to white so it doesnt trail the rotated circle
  
  leftAngleOffset -= 0.05; // Adjust the speed of rotation as needed
  rightAngleOffset += 0.05; // Adjust the speed of rotation as needed
  
  drawrightcircle(245, 250, 150, 120, "BAZOMLYXITSRQDEPCNKJWHUGVF", leftAngleOffset);//left
  drawleftircle(555, 250, 150, 120, "BQDSEFGHLWIKCMOPRTUVJXAYZN", rightAngleOffset);//right
  //SEFGHLWIKCMOPRTUVJXAYZNXQD
  //DQXNZYAXJVUTRPOMCKIWLHGFES
  //QXNZYAXJVUTRPOMCKIWLHGFESD
  //BAZOMLYXITSRQDEPCNKJWHUGVF
  //CMOPRTUVJXAYZNBQDSEFGHLWIK
  //KIWLHGFESDQBNZYAXJVUTRPOMC
  //
  
  labelZenith(245, 210, 150); // Left label zenith
  labelZenith(555, 210, 150); // Right label zenith
  labelNadir(245, 630, 150);
  labelNadir(555, 630, 150);
  
  //draw arrow for right circle
  strokeWeight(2);
  stroke(255,0,0);
  drawArrow(245,50,40, HALF_PI); //down from the zenith
  stroke(0,255,0);
  drawArrow(245,450,40, -HALF_PI); //up from the nadir
  //draw arrow for left circle
  stroke(0,0,255);
  drawArrow(555,50,40,HALF_PI); //down from the zenith
   stroke(0,0,255);
  drawArrow(555,450,40,-HALF_PI); //up from the nadir
  
  //need to figure out how to delay at letter C
  delay(100);
}

void keyPressed() {
  final int k = keyCode;

  if (k == 'S')
    if (looping)  noLoop();
    else          loop();
}

void drawrightcircle(float x, float y, float r, float inner, String cipher, float angleOffset) {
  int numsection = 26;
  float section = TWO_PI / numsection; // divides into equal sections of 26
  float notchRadius = r; 
  float notchSize = 20; // Size of the notch
  
  for (int i = 0; i < numsection; i++){
    float startAngle = i * section + angleOffset; // 0 * angelOffset so doesnt tilt
    float endAngle = (i + 1) * section + angleOffset;//makes it always a section titled cuz 1 * angleOffset
    
    // outter circle
    noFill();
    stroke(0); // Set the stroke to black
    strokeWeight(1); 
    
    //fill(255,0,0);
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
    float notchX = x + notchRadius * cos(middleAngle); // X 
    float notchY = y + notchRadius * sin(middleAngle); // Y 
    
    arc(notchX, notchY, notchSize, notchSize, middleAngle - HALF_PI, middleAngle + HALF_PI, OPEN); // Draw the notch
    
  }
  
}

void drawleftircle(float x, float y, float r, float inner, String cipher, float angleOffset) {
  int numsection = 26;
  float section = TWO_PI / numsection; // divides into equal sections of 26
  float notchRadius = r; 
  float notchSize = 20; // Size of the notch
  
  for (int i = 0; i < numsection; i++){
    float startAngle = i * section + angleOffset; // 0 * angelOffset so doesnt tilt
    float endAngle = (i + 1) * section + angleOffset;//makes it always a section titled cuz 1 * angleOffset
    
    // outter circle
    noFill();
    stroke(0); // Set the stroke to black
    strokeWeight(1); 
    
    //fill(255,0,0);
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
  
    
    // Draw the notch, that needs to be in between the lines not on the section
    float notchX2 = x + notchRadius * cos(startAngle); // X 
    float notchY2 = y + notchRadius * sin(startAngle); // Y 
    
    arc(notchX2, notchY2, notchSize, notchSize, middleAngle - HALF_PI, middleAngle + HALF_PI, OPEN); // Draw the notch
  }
  
}

void labelZenith(float x, float y, float r) {
  // Position for the label at the top of the circle
  float labelX = x;
  float labelY = y - r;
  
  fill(0); 
  textAlign(CENTER, CENTER);
  text("Zenith", labelX, labelY - 20); // Draw the label slightly above the arrow
}

void labelNadir(float x, float y, float r) {
  // Position for the label at the top of the circle
  float labelX = x;
  float labelY = y - r;
  
  fill(0); 
  textAlign(CENTER, CENTER);
  text("Nadir", labelX, labelY - 20); // Draw the label slightly above the arrow
}

void drawArrow(int x, int y, int len, float angle){
  pushMatrix();
  translate(x, y);
  rotate(angle);
  line(0,0,len, 0);
  line(len, 0, len - 8, -8);
  line(len, 0, len - 8, 8);
  popMatrix();
}
