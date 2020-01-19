package com.javarush.task.task34.task3404;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6

		test(solution);


solution.delete();

	}

	private void delete(){
		String expression = "148-2^4.0";
		String numRegex = "(-?\\d+\\.?\\d*)";

		Pattern pattern = Pattern.compile(numRegex + "\\^" + numRegex);
		Matcher matcher = pattern.matcher(expression);
		while (matcher.find()){
			System.out.println(matcher.group());
			String[] nums = matcher.group().split("\\^");
			expression = normalize(expression.replace(matcher.group(), Double.toString(Math.pow(Double.parseDouble(nums[0]),Double.parseDouble(nums[1])))));
			matcher.reset(expression);
		}

	}

	public void recurse(final String expression, int countOperation) {
//		//implement

		if (countOperation==0)countOperation = getCountOperation(expression);

		if (expression.matches("^-?\\d*.?\\d+$")) {
			sout(String.format("%.2f", Double.parseDouble(expression)), countOperation);
			return;
		}

		String normalizedExpression = normalize(expression);

		//normalizedExpression = "4+8";

		if (normalizedExpression.contains("(")) {

			Pattern pattern = Pattern.compile("(\\(.[^()]+?\\))+");
			Matcher matcher = pattern.matcher(normalizedExpression);


			while (matcher.find()) {
				//countOperation += getCountOperation(matcher.group().substring(1, matcher.group().length() - 1));
				normalizedExpression = normalizedExpression.replace(matcher.group(), Double.toString(calculate(matcher.group().substring(1, matcher.group().length() - 1))));
				//normalizedExpression = normalizedExpression.replace(matcher.group(), String.format("%.2f", calculate(matcher.group().substring(1, matcher.group().length() - 1))).replaceAll(",","."));


				//открывать одни скобки или все самые глубокие
				//break;

			}
			recurse(normalizedExpression, countOperation);
			return;
		}

//		recurse(Double.toString(calculate(normalizedExpression)), (countOperation += getCountOperation(normalizedExpression)));
		recurse(Double.toString(calculate(normalizedExpression)), (countOperation));


		//calculate("cos30+tan5^2*sin45/0.1-1.297");

	}

	private void sout(String result, int countOp){
		result = result.replace(",", ".");
		result = result.replaceAll("\\.0+$", "").replaceAll("\\.[1-9]0$", result.substring(result.length()-3, result.length()-1));
		System.out.println(result + (countOp>0?" " + countOp:""));
			}


	private int getCountOperation(String expression) {
		int count = 0;

		//if (expression.matches("(-?\\d+\\.?\\d*)")) return count;



		Pattern pattern = Pattern.compile("-|\\+|\\*|\\^|/|(sin)|(cos)|(tan)");
		Matcher matcher = pattern.matcher(expression);
		while (matcher.find()) count++;

		return count;
	}

	private double calculate(String expression) {
		//int countOp = 0;


		String numRegex = "(-?\\d+\\.?\\d*)";

		//if (expression.matches(numRegex)) return Double.parseDouble(expression);
		Pattern pattern;
		Matcher matcher;

		//countOp = getCountOperation(expression);

		if (expression.contains("sin") || expression.contains("cos") || expression.contains("tan")) {

			pattern = Pattern.compile("sin" + numRegex + "|cos" + numRegex + "|tan" + numRegex);
			matcher = pattern.matcher(expression);

			while (matcher.find()) {

				String op = matcher.group().substring(0, 3);
				double num = Double.parseDouble(matcher.group().replaceAll(op, ""));

				switch (op) {
					case "sin":
						num = Math.sin(Math.toRadians(num));
						break;
					case "cos":
						num = Math.cos(Math.toRadians(num));
						break;
					case "tan":
						num = Math.tan(Math.toRadians(num));
						break;
				}

				matcher.reset((expression = normalize(expression.replace(matcher.group(), Double.toString(num)))));
			}

		}

		//не захватывает минус и .0
		if (expression.contains("^")) {
			pattern = Pattern.compile(numRegex + "\\^" + numRegex);
			matcher = pattern.matcher(expression);
			while (matcher.find()){
				String[] nums = matcher.group().split("\\^");
//				expression = normalize(expression.replace(matcher.group(), Double.toString(Math.pow(Double.parseDouble(nums[0]),Double.parseDouble(nums[1])))));
				expression = normalize( expression.substring(0, expression.indexOf(matcher.group())) + Double.toString(Math.pow(Double.parseDouble(nums[0]),Double.parseDouble(nums[1]))) + expression.substring(expression.indexOf(matcher.group())+matcher.group().length()) );
				matcher.reset(expression);
			}
		}

		if (expression.contains("*")) {
			pattern = Pattern.compile(numRegex + "\\*" + numRegex);
			matcher = pattern.matcher(expression);
			while (matcher.find()){
				String[] nums = matcher.group().split("\\*");
				expression = normalize(expression.replace(matcher.group(), Double.toString(Double.parseDouble(nums[0])*Double.parseDouble(nums[1]))));
				matcher.reset(expression);
			}
		}

		if (expression.contains("-")) {
			pattern = Pattern.compile(numRegex + "-" + numRegex);
			matcher = pattern.matcher(expression);
			while (matcher.find()){
				char[] chars = matcher.group().toCharArray();

				int lastI = 0;
				for (int i = 0; i < chars.length; i++) {
					if (chars[i]=='-') lastI = i;
				}
				expression = expression.replace(matcher.group(), matcher.group().substring(0, lastI)+"+"+matcher.group().substring(lastI));
			//matcher.reset(expression);
			}
		}
		if (expression.contains("+")) {
			pattern = Pattern.compile(numRegex + "\\+" + numRegex);
			matcher = pattern.matcher(expression);
			while (matcher.find()){
				String[] nums = matcher.group().split("\\+");
				expression = normalize(expression.replace(matcher.group(), Double.toString(Double.parseDouble(nums[0])+Double.parseDouble(nums[1]))));
				matcher.reset(expression);
			}
		}


		//System.out.println(countOp);

		return expression.matches("^-?\\d*.?\\d+$")?Double.parseDouble(expression):calculate(expression);
	}

	private String normalize(String expression) {
		boolean changed = false;
		String original = expression;
		expression = expression.replaceAll(" ", "");
		while (expression.contains("--")){
			expression = expression.replaceAll("--", "+");
		}
		while (expression.contains("++")){
			expression = expression.replaceAll("\\+\\+", "+");
		}
		while (expression.contains("+-")){
			expression = expression.replaceAll("\\+-", "-");
		}
		while (expression.contains("-+")){
			expression = expression.replaceAll("-\\+", "-");
		}
		while (expression.contains("*+")){
			expression = expression.replaceAll("\\*\\+", "*");
		}
		while (expression.startsWith("+")){
			expression = expression.substring(1);
		}
		while (expression.endsWith("-")||expression.endsWith("+")){
			expression = expression.substring(0, expression.length()-1);
		}

		changed = !original.equals(expression);

		return changed ? normalize(expression) : expression;
	}

	private static void test(Solution solution) {
		solution.recurse("tan(45)", 0);
		System.out.println("1 1 - expected output");
		solution.recurse("tan(-45)", 0);
		System.out.println("-1 2 - expected output");
		solution.recurse("0.305", 0);
		System.out.println("0.3 0 - expected output");
		solution.recurse("0.3051", 0);
		System.out.println("0.31 - expected output");
		solution.recurse("(0.3051)", 0);
		System.out.println("0.31 - expected output");
		solution.recurse("1+(1+(1+1)*(1+1))*(1+1)+1", 0);
		System.out.println("12 8 - expected output");

		solution.recurse("tan(44+sin(89-cos(180)^2))", 0);
		System.out.println("1 6 - expected output");
		solution.recurse("-2+(-2+(-2)-2*(2+2))", 0);
		System.out.println("-14 8 - expected output");
		solution.recurse("sin(80+(2+(1+1))*(1+1)+2)", 0);
		System.out.println("1 7 - expected output");
		solution.recurse("1+4/2/2+2^2+2*2-2^(2-1+1)", 0);
		System.out.println("6 11 - expected output");
		solution.recurse("10-2^(2-1+1)", 0);
		System.out.println("6 4 - expected output");
		solution.recurse("2^10+2^(5+5)", 0);
		System.out.println("2048 4 - expected output");
		solution.recurse("1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1", 0);
		System.out.println("72.96 8 - expected output");
		solution.recurse("0.000025+0.000012", 0);
		System.out.println("0 1 - expected output");
		solution.recurse("-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)", 0);
		System.out.println("-3 16 - expected output");
		solution.recurse("cos(3 + 19*3)", 0);
		System.out.println("0.5 3 - expected output");
		solution.recurse("2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)", 0);
		System.out.println("8302231.36 14 - expected output");
		solution.recurse("(-1 + (-2))", 0);
		System.out.println("-3 3 - expected output");
		solution.recurse("-sin(2*(-5+1.5*4)+28)", 0);
		System.out.println("-0.5 7 - expected output");
		solution.recurse("sin(100)-sin(100)", 0);
		System.out.println("0 3 - expected output");
		solution.recurse("-(-22+22*2)", 0);
		System.out.println("-22 4 - expected output");
		solution.recurse("-2^(-2)", 0);
		System.out.println("-0.25 3 - expected output");
		solution.recurse("-(-2^(-2))+2+(-(-2^(-2)))", 0);
		System.out.println("2.5 10 - expected output");
		solution.recurse("(-2)*(-2)", 0);
		System.out.println("4 3 - expected output");
		solution.recurse("(-2)/(-2)", 0);
		System.out.println("1 3 - expected output");
		solution.recurse("sin(-30)", 0);
		System.out.println("-0.5 2 - expected output");
		solution.recurse("cos(-30)", 0);
		System.out.println("0.87 2 - expected output");
		solution.recurse("tan(-30)", 0);
		System.out.println("-0.58 2 - expected output");
		solution.recurse("2+8*(9/4-1.5)^(1+1)", 0);
		System.out.println("6.5 6 - expected output");
		solution.recurse("0.005", 0);
		System.out.println("0.01 0 - expected output");
		solution.recurse("0.0049", 0);
		System.out.println("0 0 - expected output");
		solution.recurse("0+0.304", 0);
		System.out.println("0.3 1 - expected output");
		solution.recurse("sin(45) - cos(45)", 0);
		System.out.println("0 3 - expected output");
		solution.recurse("0/(-3)", 0);
		System.out.println("0 2 - expected output");
	}

//	private void notRecursive(String expression, int countOperation) {
//		//not recursive
//		Pattern pattern = Pattern.compile("(\\(.[^()]+?\\))+");
//		Matcher matcher = pattern.matcher(expression);
//		while (matcher.find()) {
//			System.out.println(matcher.group());
//			matcher.reset((expression = matcher.replaceAll(Double.toString(calculate(matcher.group())))));
//		}
//
//		 System.out.println(calculate(expression) + " " + countOperation);
//	}

//	private double calculate(String expression) {
//
//		String numRegex = "(-*\\d+\\.?\\d*)";
//
//		Pattern pattern;
//		Matcher matcher;
//
//
//
//		if (expression.contains("sin")) {
//
//			pattern = Pattern.compile("sin" + numRegex);
//			matcher = pattern.matcher(expression);
//			while (matcher.find()) {
//				double degree = Double.parseDouble(matcher.group().split("sin")[1]);
//
//				expression = matcher.replaceAll(Double.toString(
//						Math.sin(Math.toRadians(degree))
//				));
//		expression = expression.replaceAll("\\+\\+", "\\+").replaceAll("--", "-");
//				matcher.reset(expression);
//			}
//
//		}
//
//
//		if (expression.contains("cos")) {
//
//			pattern = Pattern.compile("cos" + numRegex);
//			matcher = pattern.matcher(expression);
//			while (matcher.find()) {
//				double degree = Double.parseDouble(matcher.group().split("cos")[1]);
//
//				expression = matcher.replaceAll(Double.toString(
//						Math.cos(Math.toRadians(degree))
//				));
//			expression = expression.replaceAll("\\+\\+", "\\+").replaceAll("--", "-");
//				matcher.reset(expression);
//
//			}
//
//		}
//
//
//		if (expression.contains("tan")) {
//
//			pattern = Pattern.compile("tan" + numRegex);
//			matcher = pattern.matcher(expression);
//			while (matcher.find()) {
//				double degree = Double.parseDouble(matcher.group().split("tan")[1]);
//
//				expression = matcher.replaceAll(Double.toString(
//						Math.tan(Math.toRadians(degree))
//				));
//			expression = expression.replaceAll("\\+\\+", "\\+").replaceAll("--", "-");
//				matcher.reset(expression);
//
//			}
//
//		}
//
//		if (expression.contains("^")) {
//			pattern = Pattern.compile(numRegex + "\\^" + numRegex);
//			matcher = pattern.matcher(expression);
//			while (matcher.find()) {
//				String[] nums = matcher.group().split("\\^");
//
//				expression = matcher.replaceAll(Double.toString(
//						Math.pow(
//								Double.parseDouble(nums[0]),
//								Double.parseDouble(nums[1])
//						)
//				));
//				expression = expression.replaceAll("\\+\\+", "\\+").replaceAll("--", "-");
//
//				matcher.reset(expression);
//
//			}
//
//		}
//
//		if (expression.contains("*")) {
//
//			pattern = Pattern.compile(numRegex + "\\*" + numRegex);
//			matcher = pattern.matcher(expression);
//			while (matcher.find()) {
//				String[] nums = matcher.group().split("\\*");
//
//
//				String replacement = Double.toString(
//						Double.parseDouble(nums[0]) * Double.parseDouble(nums[1])
//				);
//
//				if (nums[0].startsWith("-")) replacement = "+" + replacement;
//
//				expression = matcher.replaceAll(replacement);
//				expression = expression.replaceAll("\\+\\+", "\\+").replaceAll("--", "-");
//matcher.reset(expression);
//			}
//
//		}
//
//
//		if (expression.contains("/")) {
//
//			pattern = Pattern.compile(numRegex + "/" + numRegex);
//			matcher = pattern.matcher(expression);
//			while (matcher.find()) {
//				String[] nums = matcher.group().split("/");
//
//				String replacement = Double.toString(
//						Double.parseDouble(nums[0]) / Double.parseDouble(nums[1])
//				);
//
//				if (nums[0].startsWith("-")) replacement = "+" + replacement;
//
//				expression = matcher.replaceAll(replacement);
//				expression = expression.replaceAll("\\+\\+", "\\+").replaceAll("--", "-");
//
//				matcher.reset(expression);
//			}
//
//		}
//
//
//		if (expression.contains("+")) {
//
//			pattern = Pattern.compile(numRegex + "\\+" + numRegex);
//			matcher = pattern.matcher(expression);
//			while (matcher.find()) {
//				String[] nums = matcher.group().split("\\+");
//
//				String replacement = Double.toString(
//						Double.parseDouble(nums[0]) + Double.parseDouble(nums[1])
//				);
//
//				if (Double.parseDouble(replacement)>=0) replacement = "+"+replacement;
//				else replacement = "+-"+replacement;
//
//				expression = matcher.replaceAll(replacement);
//				expression = expression.replaceAll("\\+\\+", "\\+").replaceAll("--", "-");
//
//				matcher.reset(expression);
//			}
//
//		}
//		expression = expression.replaceAll("\\+\\+", "\\+").replaceAll("--", "-").replaceAll("\\+-", "-");
//
//		return Double.parseDouble(expression);
//	}

	public Solution() {
		//don't delete
	}





}
