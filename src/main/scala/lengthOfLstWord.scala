object lengthOfLstWord {
  def lengthOfLastWord(s: String): Int = {
    if(s.length == 0 || s == null)
      0

    var ret = s.trim.split(" ")

    ret(ret.size-1).length
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLastWord("luffy is still joyboy"))
  }

}
