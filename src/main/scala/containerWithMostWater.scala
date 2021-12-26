object containerWithMostWater {
  //11
  def maxArea(height: Array[Int]): Int = {
    var end = height.length-1
    var start = 0
    var ret = 0

    while(start < end){
      if(height(start) > height(end)){
        ret = Math.max(ret,height(end)*(end-start))
        end -= 1
      }else{
        ret = Math.max(ret,height(start)*(end-start))
        start += 1
      }
    }

    ret
  }

  def maxAreaBad(height: Array[Int]): Int = {
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
    var tt = Array[Int](1,8,6,2,5,4,8,3,7)
    println(maxArea(tt))
  }
}
