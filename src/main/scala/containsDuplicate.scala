object containsDuplicate {
  //217
  def containsDuplicate(nums: Array[Int]): Boolean = {
    !nums.sameElements(nums.distinct)
  }

  def main(args: Array[String]): Unit = {
    var tt = Array[Int](1,1,1,3,3,4,3,2,4,2)
    println(containsDuplicate(tt))
  }

}
