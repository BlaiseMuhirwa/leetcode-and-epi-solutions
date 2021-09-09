class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<List<Integer>>();
        } else if (numRows == 1) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            List<Integer> firstNum = new ArrayList<>();
            firstNum.add(1);
            list.add(firstNum);
            return list;
        }
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        output.add(firstRow);
        for (int i=1; i < numRows; i++) {
            int size = i;
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for (int j = 1; j < size; j++) {
                int prevFirst = output.get(i-1).get(j-1);
                int prevSecond = output.get(i-1).get(j);
                newList.add(prevFirst + prevSecond);
            }
            newList.add(1);
            output.add(newList);
        }
        return output;
        
    }
}
