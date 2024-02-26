class Solution {
    public static String solution(String new_id) {
        new_id = step1(new_id);
        new_id= step2(new_id);
        new_id = step3(new_id);
        new_id = step4(new_id);
        new_id = step5(new_id);
        new_id = step6(new_id);
        new_id = step7(new_id);

        return new_id;
    }

    private static String step7(String newId) {
        StringBuilder newIdBuilder = new StringBuilder(newId);
        while (newIdBuilder.length() < 3) {
            newIdBuilder.append(newIdBuilder.charAt(newIdBuilder.length() - 1));
        }
        newId = newIdBuilder.toString();
        return newId;
    }

    private static String step6(String newId) {
        if (newId.length() >= 16) {
            newId = newId.substring(0, 15);
        }
        return newId.replaceAll("\\.$", "");
    }

    private static String step5(String newId) {
        if (newId.isBlank()) {
            return "a";
        }
        return newId;
    }

    private static String step4(String newId) {
        newId = newId.replaceFirst("^\\.", "");
        return newId.replaceAll("\\.$", "");
    }

    private static String step3(String newId) {
        return newId.replaceAll("\\.{2,}", ".");
    }

    private static String step2(String newId) {
        return newId.replaceAll("[^a-z0-9\\-_.]", "");
    }

    private static String step1(String newId) {
        return newId.toLowerCase();
    }
}