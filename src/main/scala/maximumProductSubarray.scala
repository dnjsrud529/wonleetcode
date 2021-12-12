object maximumProductSubarray {
  //152
  def maxProduct(nums: Array[Int]): Int = {
    var max = nums(0)
    if(nums.filter(x => x <0).length > 0)
      max = 0
    var startIdx = 0

    if(nums.length == 1)
      return nums(0)

    nums.zipWithIndex.foreach{
      case(num,i) => {
        if(num == 0) {
          max = Math.max(max,multiNum(nums.slice(startIdx,i)))
          startIdx = i+1
        }
        if(i == nums.length-1){
          max = Math.max(max,multiNum(nums.slice(startIdx,i+1)))
        }
      }
    }

    max
  }

  def multiNum(checkNums: Array[Int]) : Int = {
    if(checkNums.length == 0)
      return 0
    val under = checkNums.filter(x => x<0).length
    var ret = 1
    var temp = 1

    if(checkNums.length == 1)
      return checkNums(0)

    if(under % 2 == 0){
      checkNums.foreach(cn => {
        ret = ret * cn
      })
    }else{
      var idx = 0
      var left = 1
      var right = 1
      var leftChk = true
      var rightChk = false
      var leftCnt = 0
      var rightCnt = 0
      checkNums.foreach(cn => {
        if(cn < 0){
          if(idx == 0)
            rightChk = true
          if(idx == under-1)
            leftChk = false
          idx += 1
        }
        if(leftChk) {
          left = left * cn
          leftCnt += 1
        }
        if(rightChk) {
          if(rightCnt != 0)
            right = right * cn
          rightCnt += 1
        }
      })

      if(rightCnt == 0)
        ret = Math.max(ret,left)
      else if(leftCnt == 0)
        ret = Math.max(ret,right)
      else
        ret = Math.max(left,right)

    }
    ret
  }

  //good.. why i can't this thinking
  def GoodmaxProduct(nums: Array[Int]): Int = {
    var res = nums(0)
    var cnt = 1
    nums.indices.foreach(i => {
      cnt = cnt * nums(i)
      res = res.max(cnt)
      if (nums(i) == 0) cnt = 1
    })
    cnt = 1
    (nums.length - 1 to 0 by -1).foreach(i => {
      cnt = cnt * nums(i)
      res = res.max(cnt)
      if (nums(i) == 0) cnt = 1
    })
    res
  }

  def main(args: Array[String]): Unit = {
    var tt = Array[Int](-2,-1,0,-1,2,-3,1,2,3,-2)
    println(maxProduct(tt))
  }

}
