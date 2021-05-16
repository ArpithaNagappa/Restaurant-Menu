package restaurant;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuItem extends Menu {
    private Double price;
    private String category;
    private String description;
    private String lastUpdated;


    public double getPrice()
    {
        return price;
    }

    protected void setPrice(double newPrice)
    {
        price = newPrice;
    }

    public String getCategory()
    {
        return category;
    }

    protected void setCategory(String newCategory)
    {
        category = newCategory;
    }

    public String getDescription()
    {
        return description;
    }

    protected void setDescription(String newDescription)
    {
        category = newDescription;
    }

    public String getLastUpdated()
    {
        return lastUpdated;
    }

    protected void setLastUpdated(String newLastUpdated)
    {
        lastUpdated = newLastUpdated;
    }

    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        //String now1 = dtf.format(now);
        //System.out.println(now1);
        LocalDate dateNow = LocalDate.parse(dtf.format(now));
        LocalDate dateBefore = LocalDate.parse(getLastUpdated());
        float days = ChronoUnit.DAYS.between(dateNow, dateBefore);
        String itemNew;
        if(days <= 30)
            itemNew = "Item is New";
        else
            itemNew = "Item is Old";
        return String.format("%s , %s, %f, %s, %s", getCategory(), getDescription(), getPrice(), getLastUpdated(), itemNew);
    }

    public MenuItem(String menuCategory, String menuDescription, double menuPrice)
    {
        price = menuPrice;
        category = menuCategory;
        description = menuDescription;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        lastUpdated = dtf.format(now);

    }
}
