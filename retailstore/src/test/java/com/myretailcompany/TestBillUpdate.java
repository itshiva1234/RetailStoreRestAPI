package com.myretailcompany;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import com.myretailcompany.rest.controller.bill.beans.BillUpdateInfo;
import com.myretailcompany.rest.controller.bill.beans.ProductInfoForBill;
import com.myretailcompany.util.BillStatus;

@RunWith(SpringRunner.class)
@JsonTest
public class TestBillUpdate {

	@Autowired
	private JacksonTester<BillUpdateInfo> json;

	public BillUpdateInfo createTestBean() {
		BillUpdateInfo updateInfo = new BillUpdateInfo();
		updateInfo.setStatus(BillStatus.IN_PROGRESS);
		List<ProductInfoForBill> productsToBeAdded = new ArrayList<ProductInfoForBill>();
		productsToBeAdded.add(new ProductInfoForBill("ABC-abc-1234", 20));
		productsToBeAdded.add(new ProductInfoForBill("ABC-abc-2234", 30));
		productsToBeAdded.add(new ProductInfoForBill("ABC-abc-3234", 10));

		List<ProductInfoForBill> productsToBeRemoved = new ArrayList<ProductInfoForBill>();
		productsToBeRemoved.add(new ProductInfoForBill("ABC-abc-1235", 2));
		productsToBeRemoved.add(new ProductInfoForBill("ABC-abc-1236", 3));
		productsToBeRemoved.add(new ProductInfoForBill("ABC-abc-1237", 1));

		updateInfo.setProductsToBeAdded(productsToBeAdded);
		updateInfo.setProductsToBeRemoved(productsToBeRemoved);
		return updateInfo;
	}

	@Test
	public void testSerialize() throws Exception {

		BillUpdateInfo updateInfo = createTestBean();

		assertThat(this.json.write(updateInfo)).isEqualToJson("expected.json");

		System.out.println(this.json.write(updateInfo).toString());
	}

}
