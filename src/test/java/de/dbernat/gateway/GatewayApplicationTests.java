package de.dbernat.gateway;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class GatewayApplicationTests {

	@Test
	void contextLoads() {
		assertTrue("fail forever", false);
	}

}
