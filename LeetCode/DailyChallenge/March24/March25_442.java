package DailyChallenge.March24;

import java.util.ArrayList;
import java.util.List;

public class March25_442{
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			// Take the absolute value of the current number
			int num = Math.abs(nums[i]);
			// Calculate the index based on the value of the number
			int idx = num - 1;

			// If the number at the calculated index is negative,
			// it means we have encountered this number before
			if (nums[idx] < 0)
				result.add(num);

			// Mark the number at the calculated index as visited
			nums[idx] *= -1;
		}

		return result;
	}
}
