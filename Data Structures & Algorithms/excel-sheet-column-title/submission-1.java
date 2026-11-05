class Solution {
    public String convertToTitle(int columnNumber) {

      StringBuilder str = new StringBuilder();

      while(columnNumber > 0)
      {
         columnNumber--;

         int rem = columnNumber % 26;

         str.append((char)('A' + rem));

         columnNumber = columnNumber / 26;
      }

      return str.reverse().toString();

    }
}