package com.website.bean;

public class GoodsInfoWithBLOBs extends GoodsInfo {
  

	private String description;

    private String goodsDesc;
    
    private Integer parent_id;
    private Integer child_id;
    private Integer category_id;
    private String labelName;

    public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }
    public Integer getParent_id() {
  		return parent_id;
  	}

  	public void setParent_id(Integer parent_id) {
  		this.parent_id = parent_id;
  	}

  	public Integer getChild_id() {
  		return child_id;
  	}

  	public void setChild_id(Integer child_id) {
  		this.child_id = child_id;
  	}

  	public Integer getCategory_id() {
  		return category_id;
  	}

  	public void setCategory_id(Integer category_id) {
  		this.category_id = category_id;
  	}
}