object twoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var returnArray = new Array[Int](2)
    var chk = true

    nums.zipWithIndex.foreach{
      case(num,i) => {
        nums.zipWithIndex.foreach{
          case(num2,j) => {
            if(i != j){
              if(nums(i) + nums(j) == target && chk){
                returnArray(0)=i
                returnArray(1)=j
                chk = false
              }
            }
          }
        }
      }
    }

    returnArray
  }

  def main(args: Array[String]): Unit = {
    println(twoSum(Array(2,7,11,15),9))
  }
}
