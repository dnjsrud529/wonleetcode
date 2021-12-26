object threeSum {

  def threeSum(nums: Array[Int]): List[List[Int]] = {

    if(nums.size < 3)
      return null

    var ret = scala.collection.mutable.Set[List[Int]]()
    val map = scala.collection.mutable.Map.empty[Int,Int]

    for(i <- 0 to nums.length - 2){
      val firstnum = nums(i)
      map.put(i,firstnum)
      for(j <- i+1 to nums.length -1){
        val secondNum = nums(j)
        map.put(j,secondNum)

        val chkVal = 0 - (firstnum + secondNum)

        val isIn = map.find(_._2 == chkVal).map(_._1)
        if(!isIn.isEmpty && !isIn.contains(i) && !isIn.contains(j))
          ret += List(firstnum,secondNum,chkVal).sorted

      }
    }

    ret.toList

  }

  def threeSumBad(nums: Array[Int]): List[List[Int]] = {
    //15
    if(nums.size < 3)
      return null


    nums.combinations(3).filter(_.sum != 0).map(_.toList).toList

  }

  def main(args: Array[String]): Unit = {
    var tt = Array[Int](-1,0,1,2,-1,-4)
    println(threeSum(tt))
  }
}
