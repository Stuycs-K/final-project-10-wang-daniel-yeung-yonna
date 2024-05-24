void setup() {
  size(800, 400);
  background(255);
  
  drawcircle(200, 200, 150);
  drawcircle(600, 200, 150);
}

void drawcircle(float x, float y, float r) {
  int numsection = 26;
  float section = TWO_PI / numsection; // divides into equal sections of 26
  
  for (int i = 0; i < numsection; i++){
    float startAngle = i * section;
    float endAngle = (i + 1) * section;
    
    //draw the slice of the circle
    noFill();
    stroke(0); // Set the stroke to black
    strokeWeight(1); 

    arc(x, y, r * 2, r * 2, startAngle, endAngle, PIE);
  }
  
}