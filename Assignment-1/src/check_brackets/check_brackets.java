package check_brackets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
	Bracket(char type, int position) {
		this.type = type;
		this.position = position;
	}

	boolean Match(char c) {
		if (this.type == '[' && c == ']')
			return true;
		if (this.type == '{' && c == '}')
			return true;
		if (this.type == '(' && c == ')')
			return true;
		return false;
	}

	char type;
	int position;
}

class check_brackets {
	public static void main(String[] args) throws IOException {
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		String text = reader.readLine();
		int flag = 0;
		int ans =0;
		Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();

		for (int position = 0; position < text.length(); ++position) {
			char next = text.charAt(position);
			Bracket item = new Bracket(next,position);
			if (next == '(' || next == '[' || next == '{') {
				// Process opening bracket, write your code here
				opening_brackets_stack.push(item);
			}

			if (next == ')' || next == ']' || next == '}') {
				// Process closing bracket, write your code here
				if(opening_brackets_stack.empty()) {
					flag++;
					ans= item.position + 1;
					break;
				}
				else
	            {
	              Bracket temp=opening_brackets_stack.peek();
	              if(temp.Match(next))
	            	  opening_brackets_stack.pop();
	               else
	               {
	                   flag++;
	               ans=item.position+1;
	                   break;
	            }
	            }
				if(flag==1)
		            System.out.println(ans);
		            else
		            {
		              if(!opening_brackets_stack.empty())
		              {
		                Bracket p =opening_brackets_stack.pop();
		                System.out.println(p.position+1);
		                }
		                else
		                System.out.println("Success");
		            }

			}
		}

		// Printing answer, write your code here
	}
}
