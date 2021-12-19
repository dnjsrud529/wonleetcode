object containerWithMostWater {
  //11
  def maxArea(height: Array[Int]): Int = {
    var weight = height.length-1
    var minSide = Math.min(height(0),height(height.length-1))
    var ret = minSide * weight

    if(height.length == 2)
      return ret

    for(i <- weight - 1 to 1 by -1){
      var cnt = 0
      while(i + cnt < height.length){
        if(Math.min(height(cnt),height(i+cnt)) > minSide){
          minSide = Math.min(height(cnt),height(i+cnt))
          ret = Math.max(ret,(Math.min(height(cnt),height(i+cnt)) * i))
        }
        cnt += 1
      }
    }

    ret
  }

  def main(args: Array[String]): Unit = {
    var tt = Array[Int](2,3,4,5,18,17,6)
    println(maxArea(tt))
  }
}
