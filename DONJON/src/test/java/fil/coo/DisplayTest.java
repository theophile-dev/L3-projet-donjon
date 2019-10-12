package fil.coo;

import java.util.ArrayList;

import org.junit.Test;

public class DisplayTest {
	

	@Test(expected = EmptyListException.class)
	public void testListChooseEmptyListException() throws EmptyListException {
		Display display = Display.getInstance();
		ArrayList<DisplayableMock> DisplayableMockArray = new ArrayList<DisplayableMock>();
		display.listChoose(DisplayableMockArray);
	}
	
	public class DisplayableMock implements Displayable {
		
		private String name;
		
		public DisplayableMock(String name) {
			this.name = name;
		}
		
		@Override
		public String getDescription() {
			return "My name is " + name;
		}
		
	}
}
