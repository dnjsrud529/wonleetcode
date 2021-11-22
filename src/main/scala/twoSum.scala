object twoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var returnArray = new Array[Int](2)
    var chkin = true

    //zipWithIndex를 사용 시 foreach에서 index 접근 가능
    nums.zipWithIndex.foreach{
      case(num,i) => {
        val chk = target - num
        //target과의 차이를 구한 후 그 차이 값을 포함하고 있는지 확인
        if(nums.contains(chk) && chkin && i != nums.indexOf(chk)){
          returnArray(0) = i
          returnArray(1) = nums.indexOf(chk)
          chkin = false
        }

      }
    }

    returnArray

  }

  def main(args: Array[String]): Unit = {
    println(twoSum(Array(2,7,11,15),9))
  }
}
