package com.example.fragment;

public class Description {
    private String name;
    private String desc;
    private int imgres;

    private Description (String n,String d,int i)
    {
        this.name=n;
        this.desc=d;
        this.imgres=i;
    }

    public static final Description [] descriptionArray={
        new Description("Cheetah","The cheetah (Acinonyx jubatus; /ˈtʃiːtə/) is a large cat of the subfamily Felinae that occurs in North, Southern and East " +
                "Africa, and a few localities in Iran. It inhabits a variety of mostly arid habitats like dry forests, scrub forests, " +
                "and savannahs. The species is IUCN Red Listed as Vulnerable, as it suffered a substantial decline in its historic range in the 20th century due to habitat" +
                " loss, poaching for the illegal pet trade, and conflict with humans. By 2016, the glob" +
                "al cheetah population has been estimated at approximately 7,100 individuals in the wild. Several African countries have taken steps to im" +
                "prove cheetah conservation measures.",R.drawable.cheetah),
        new Description("Bear","The cheetah (Acinonyx jubatus; /ˈtʃiːtə/) is a large cat of the subfamily Felinae that occurs in North, Southern and East " +
                "Africa, and a few localities in Iran. It inhabits a variety of mostly arid habitats like dry forests, scrub forests, " +
                "and savannahs. The species is IUCN Red Listed as Vulnerable, as it suffered a substantial decline in its historic range in the 20th century due to habitat" +
                " loss, poaching for the illegal pet trade, and conflict with humans. By 2016, the glob" +
                "al cheetah population has been estimated at approximately 7,100 individuals in the wild. Several African countries have taken steps to im" +
                "prove cheetah conservation measures.",R.drawable.br),
        new Description("Elephant","The cheetah (Acinonyx jubatus; /ˈtʃiːtə/) is a large cat of the subfamily Felinae that occurs in North, Southern and East " +
                "Africa, and a few localities in Iran. It inhabits a variety of mostly arid habitats like dry forests, scrub forests," +
                "and savannahs. The species is IUCN Red Listed as Vulnerable, as it suffered a substantial decline in its historic range in the 20th century due to habitat" +
                " loss, poaching for the illegal pet trade, and conflict with humans. By 2016, the glob" +
                "al cheetah population has been estimated at approximately 7,100 individuals in the wild. Several African countries have taken steps to im" +
                "prove cheetah conservation measures.",R.drawable.el),
        new Description("Lion","The cheetah (Acinonyx jubatus; /ˈtʃiːtə/) is a large cat of the subfamily Felinae that occurs in North, Southern and East" +
                "Africa, and a few localities in Iran. It inhabits a variety of mostly arid habitats like dry forests, scrub forests," +
                "and savannahs. The species is IUCN Red Listed as Vulnerable, as it suffered a substantial decline in its historic range in the 20th century due to habitat" +
                " loss, poaching for the illegal pet trade, and conflict with humans. By 2016, the glob" +
                "al cheetah population has been estimated at approximately 7,100 individuals in the wild.Several African countries have taken steps to im" +
                "prove cheetah conservation measures.",R.drawable.lion)

    };

    public String getName(){
     return name;
    }
    public String getDesc(){
        return desc;
    }
    public int getImgres(){
        return imgres;
    }
    public String toString(){
        return this.name;
    }
}
