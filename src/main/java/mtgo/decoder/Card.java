package mtgo.decoder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author North
 */
public class Card {

    private Integer cardId;
    private Integer cardIdPair;
    private Integer baseCardId;
    private Boolean foil;
    private String name;
    private String artist;
    private String set;
    private String cost;
    private String rarity;
    private String image;
    private String cardNo;
    private String pt;
    private String flavor;
    private String watermark;
    private String convertedManaCost;
    private String cToken;
    private String ability;
    private String creatureType;
    private String color;
    private List<String> types;
    private List<Integer> keys;
    private List<Integer> values;

    public Card(Integer doId, Integer doIdPair) {
        this.cardId = doId;
        this.cardIdPair = doIdPair;
        this.foil = false;
        keys = new ArrayList<>();
        values = new ArrayList<>();
        types = new ArrayList<>();
    }

    public void addType(String type) {
        types.add(type);
    }

    public List<String> getTypes() {
        return types;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCreatureType() {
        return creatureType;
    }

    public void setCreatureType(String creatureType) {
        this.creatureType = creatureType;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability1) {
        this.ability = ability1;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getWatermark() {
        return watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    public Integer getBaseCardId() {
        return baseCardId;
    }

    public void setBaseCardId(Integer baseCardId) {
        this.baseCardId = baseCardId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getCardIdPair() {
        return cardIdPair;
    }

    public void setCardIdPair(Integer cardIdPair) {
        this.cardIdPair = cardIdPair;
    }

    public Boolean isFoil() {
        return foil;
    }

    public void setFoil(Boolean foil) {
        this.foil = foil;
    }

    public String getConvertedManaCost() {
        return convertedManaCost;
    }

    public void setConvertedManaCost(String convertedManaCost) {
        this.convertedManaCost = convertedManaCost;
    }

    public String getcToken() {
        return cToken;
    }

    public void setcToken(String cToken) {
        this.cToken = cToken;
    }

    public void addUnusedPair(Integer key, Integer value) {
        keys.add(key);
        values.add(value);
    }

    public void printUnused() {
        for (Integer i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " " + values.get(i));
        }
    }

    public void copyFromBaseCard(final Card baseCard) {
        if (this.name == null) {
            this.name = baseCard.name;
        }
        if (this.color == null) {
            this.color = baseCard.color;
        }
        if (this.cost == null) {
            this.cost = baseCard.cost;
        }
        if (this.convertedManaCost == null) {
            this.convertedManaCost = baseCard.convertedManaCost;
        }
        if (this.creatureType == null) {
            this.creatureType = baseCard.creatureType;
        }
        if (this.cToken == null) {
            this.cToken = baseCard.cToken;
        }
        if (this.pt == null) {
            this.pt = baseCard.pt;
        }
        if (this.ability == null) {
            this.ability = baseCard.ability;
        }
        if (this.types.isEmpty()) {
            this.types.clear();
            this.types.addAll(baseCard.getTypes());
        }
    }

    public String getImageData() {
        StringBuilder sb = new StringBuilder();
        sb.append(set).append("|").append(name).append("|").append(cardNo.split("/")[0]).append("|");
        for (int i = image.length(); i < 5; i++) {
            sb.append('0');
        }
        sb.append(image);
        return sb.toString();
    }

    public String getDebugData() {
        StringBuilder sb = new StringBuilder();
        sb.append(set).append("|").append(name).append("|").append(cardNo.split("/")[0]).append("|");
        for (int i = image.length(); i < 5; i++) {
            sb.append('0');
        }
        sb.append(cardId);
        return sb.toString();
    }

    public String getFullData() {
        StringBuilder sb = new StringBuilder();
        sb.append(set).append("|");
        sb.append(cardNo).append("|");
        sb.append(name).append("|");
        if (!types.isEmpty()) {
            sb.append(types.get(0));
        }
        for (int i = 1; i < types.size(); i++) {
            sb.append(" ").append(types.get(i));
        }
        sb.append("|");
        for (int i = image.length(); i < 5; i++) {
            sb.append('0');
        }
        sb.append(image).append("|");
        sb.append(artist).append("|");
        sb.append(color).append("|");
        sb.append(cost == null ? "" : cost).append("|");
        sb.append(convertedManaCost).append("|");
        sb.append(creatureType == null ? "" : creatureType).append("|");
        sb.append(pt == null ? "" : pt).append("|");
        sb.append(flavor == null ? "" : flavor).append("|");
        sb.append(ability).append("|");
        sb.append(rarity).append("|");
        sb.append(watermark == null ? "" : watermark).append("|");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(set).append("|");
        sb.append(cardNo).append("|");
        sb.append(name).append("|");
        if (!types.isEmpty()) {
            sb.append(types.get(0));
        }
        for (int i = 1; i < types.size(); i++) {
            sb.append(" ").append(types.get(i));
        }
        sb.append("|");
        for (int i = image.length(); i < 5; i++) {
            sb.append('0');
        }
        sb.append(image).append("|");
        sb.append(artist).append("|");
        sb.append(color).append("|");
        sb.append(cost == null ? "" : cost).append("|");
        sb.append(convertedManaCost).append("|");
        sb.append(creatureType == null ? "" : creatureType).append("|");
        sb.append(cToken).append("|");
        sb.append(pt == null ? "" : pt).append("|");
        sb.append(flavor == null ? "" : flavor).append("|");
        sb.append(ability).append("|");
        sb.append(rarity).append("|");
        sb.append(foil).append("|");
        sb.append(watermark == null ? "" : watermark).append("|");
        sb.append(cardId).append("|");
        sb.append(cardIdPair).append("|");
        sb.append(baseCardId).append("|");
        return sb.toString();
    }
}
