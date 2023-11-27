import{l as a,N as r,I as e,_ as c,O as o}from"./indexhtml-34efa00b.js";const t={selector:"vaadin-checkbox",displayName:"Checkbox",properties:[{propertyName:"--vaadin-checkbox-size",displayName:"Checkbox size",defaultValue:"var(--lumo-font-size-l)",editorType:a.range,presets:r.lumoFontSize,icon:"square"}]},l={selector:"vaadin-checkbox::part(checkbox)",displayName:"Checkbox box",properties:[e.backgroundColor,e.borderColor,e.borderWidth,e.borderRadius]},s={selector:"vaadin-checkbox[checked]::part(checkbox)",stateAttribute:"checked",displayName:"Checkbox box (when checked)",properties:[e.backgroundColor,e.borderColor,e.borderWidth,e.borderRadius]},i={selector:"vaadin-checkbox::part(checkbox)::after",displayName:"Checkmark",properties:[c.iconColor]},d={selector:"vaadin-checkbox label",displayName:"Label",properties:[o.textColor,o.fontSize,o.fontWeight,o.fontStyle]},h={tagName:"vaadin-checkbox",displayName:"Checkbox",elements:[t,l,s,i,d]};export{l as checkboxElement,s as checkedCheckboxElement,i as checkmarkElement,h as default,t as hostElement,d as labelElement};
