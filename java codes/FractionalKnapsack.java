class ItemValue {

	int value, weight;

	// Item value function
	public ItemValue(int val, int wt) {
		this.weight = wt;
		this.value = val;
	}
}

class My_comparator implements Comparator<ItemValue> {
	@Override
	public int compare(ItemValue i1, ItemValue i2) {
		// TODO Auto-generated method stub
		double x = i1.value / i1.weight;
		double y = i1.value / i1.weight;
		if (y > x) {
			return 1;
		} else {
			return -1;
		}
	}
}

public class Fractional {
	// Driver code
	public static void main(String[] args) {
		ItemValue[] arr = { new ItemValue(60, 10), new ItemValue(100, 20), new ItemValue(120, 30) };

		int capacity = 50;

		double maxValue = getMaxValue(arr, capacity);

// Function call
		System.out.println(maxValue);
	}

	private static double getMaxValue(ItemValue[] arr, int capacity) {
		// TODO Auto-generated method stub
		Arrays.sort(arr, new My_comparator());
		double totalValue = 0;
		for (ItemValue i : arr) {
			int curWt = i.weight;
			int curVal = i.value;

			if (capacity - curWt >= 0) {
				// this weight can be picked while
				capacity = capacity - curWt;
				totalValue += curVal;
			} else {
				// Item cant be picked whole
				double fraction = capacity / curWt;
				totalValue += (curVal * fraction);
				capacity = (int) (capacity - (curWt * fraction));
				break;
			}
		}

		return totalValue;
	}
}
