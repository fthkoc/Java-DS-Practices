/* Creates a string from integers between 0-999 to their written versions. */
public static String makeWordFrom(int number) {
    final String[] tensNames = {"", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"};
    final String[] digitsAndSpecialNames = {"", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten",
            " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};

    if (number == 0) {
        return "zero";
    }

    String result;
    if (number % 100 < 20){
        result = digitsAndSpecialNames[number % 100];
        number /= 100;
    }
    else {
        result = digitsAndSpecialNames[number % 10];
        number /= 10;
        result = tensNames[number % 10] + result;
        number /= 10;
    }
    if (number == 0)
        return result;

    return digitsAndSpecialNames[number] + " hundred" + result;
}