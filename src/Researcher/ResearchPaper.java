package Researcher;
public class ResearchPaper {
    private String fundingAgency;
    private String authors;
    private String references;
    private String citations;
    private String title;
    private String date;

    public ResearchPaper(String fundingAgency, String authors, String references, String citations, String title, String date) {
        this.fundingAgency = fundingAgency;
        this.authors = authors;
        this.references = references;
        this.citations = citations;
        this.title = title;
        this.date = date;
    }

    public String getFundingAgency() {
        return fundingAgency;
    }

    public String getAuthors() {
        return authors;
    }

    public String getReferences() {
        return references;
    }

    public String getCitations() {
        return citations;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Research Paper{" +
                "fundingAgency='" + fundingAgency + '\'' +
                ", authors='" + authors + '\'' +
                ", references='" + references + '\'' +
                ", citations='" + citations + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getCitation() {
        return "Citations: " + citations;
    }
}
