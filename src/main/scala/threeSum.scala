object threeSum {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
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
