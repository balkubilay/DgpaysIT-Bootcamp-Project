package com.kubilaybal.dgpaysitbootcampproject;

import androidx.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoinsResponseModel {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("coin")
    @Expose
    private String coin;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("algorithm")
    @Expose
    private String algorithm;
    /*    @SerializedName("network_hashrate")
        @Expose
        private Long networkHashrate;*/
/*    @SerializedName("difficulty")
    @Expose
    private Long difficulty;*/
/*    @SerializedName("reward")
    @Expose
    private Double reward;*/
    @SerializedName("reward_unit")
    @Expose
    private String rewardUnit;
    @SerializedName("reward_block")
    @Expose
    private Double rewardBlock;
    @SerializedName("price")
    @Expose
    private Double price;
    /*    @SerializedName("volume")
        @Expose
        private Double volume;*/
    @SerializedName("updated")
    @Expose
    private Integer updated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

/*    public Long getNetworkHashrate() {
        return networkHashrate;
    }

    public void setNetworkHashrate(Long networkHashrate) {
        this.networkHashrate = networkHashrate;
    }*/

/*    public Long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Long difficulty) {
        this.difficulty = difficulty;
    }*/

/*    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }*/

    public String getRewardUnit() {
        return rewardUnit;
    }

    public void setRewardUnit(String rewardUnit) {
        this.rewardUnit = rewardUnit;
    }

    public Double getRewardBlock() {
        return rewardBlock;
    }

    public void setRewardBlock(Double rewardBlock) {
        this.rewardBlock = rewardBlock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

/*
    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }
*/

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    @NonNull
    @Override
    public String toString() {
        return "CoinsResponseModel{" +
                "id='" + id + '\'' +
                ", coin='" + coin + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", algorithm='" + algorithm + '\'' +
                ", rewardUnit='" + rewardUnit + '\'' +
                ", rewardBlock=" + rewardBlock +
                ", price=" + price +
                ", updated=" + updated +
                '}';
    }
}
