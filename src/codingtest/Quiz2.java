package codingtest;
import java.util.*;

public class Quiz2 {

    //codeId와 value가 해당하는 language와 label 값을 찾는 메소드
    private static Map<String, String> findCode(List<CodeGroup> codeGroups, String codeId, String value) {
        Map<String, String> map = new HashMap<>();
        for (CodeGroup codeGroup : codeGroups) {
            if (codeGroup.getCodeId().equals(codeId)) {
                for (CodeGroup.Code code : codeGroup.getCodes()) {
                    if (code.getValue().equals(value)) {
                        for (CodeGroup.CodeLabel label : code.getLabels()) {
                            map.put(label.getLanguage(), label.getLabel());
                        }
                        return map;
                    }
                }
            }
        }
        return map;
    }
    public static void main(String[] args) {
        //주어진 데이터값
        final List<CodeGroup> codeGroups = List.of(
                new CodeGroup("COUNTRY", List.of(
                        new CodeGroup.Code("KR", List.of(
                                new CodeGroup.CodeLabel("ko", "한국"),
                                new CodeGroup.CodeLabel("en", "Republic of Korea"))),
                        new CodeGroup.Code("CN", List.of(
                                new CodeGroup.CodeLabel("ko", "중국"),
                                new CodeGroup.CodeLabel("en", "China"))),
                        new CodeGroup.Code("DK", List.of(
                                new CodeGroup.CodeLabel("ko", "덴마크"),
                                new CodeGroup.CodeLabel("en", "Denmark"))),
                        new CodeGroup.Code("US", List.of(
                                new CodeGroup.CodeLabel("ko", "미국"),
                                new CodeGroup.CodeLabel("en", "United States")))
                )));

        Map<String, String> result = findCode(codeGroups, "COUNTRY", "KR");
        System.out.println(result);
    }

    static class CodeGroup {
        private String codeId;
        private List<Code> codes;

        public CodeGroup(String codeId, List<Code> codes) {
            this.codeId = codeId;
            this.codes = codes;
        }

        public String getCodeId() {
            return codeId;
        }

        public List<Code> getCodes() {
            return codes;
        }

        public static class Code {
            private String value;
            private List<CodeLabel> labels;

            public Code(String value, List<CodeLabel> labels) {
                this.value = value;
                this.labels = labels;
            }

            public String getValue() {
                return value;
            }

            public List<CodeLabel> getLabels() {
                return labels;
            }
        }

        public static class CodeLabel {
            private String language;
            private String label;

            public CodeLabel(String language, String label) {
                this.language = language;
                this.label = label;
            }

            public String getLanguage() {
                return language;
            }

            public String getLabel() {
                return label;
            }
        }
    }
}
